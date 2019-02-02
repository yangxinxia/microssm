package org.boluo.demo.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.boluo.demo.common.RedisLock;
import org.boluo.utils.exception.CacheLockException;
import org.boluo.utils.lock.CacheLock;
import org.boluo.utils.lock.CacheLockActionBase;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheLockAction extends CacheLockActionBase {

	@Resource
	private RedisLock redisLock;

	@Override
	@Around(value = "cutService()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object object = null;
		// 获取拦截的方法
		Signature sig = point.getSignature();
		if (!(sig instanceof MethodSignature)) {
			//throw new IllegalArgumentException("该注解只能使用在方法上！");
			logger.error("【redislock】errMsg:该注解只能使用在方法上！");
		}
		MethodSignature msig = (MethodSignature) sig;
		// 接下来通过拦截的方法名获取使用标注的方法
		Method method = null;
		try {
			method = point.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());
		} catch (NoSuchMethodException e) {
			logger.error("【redislock】errMsg:"+e.toString());
		}
		if (method == null) {
			object = point.proceed();
			return object;
		}
		if (method.isAnnotationPresent(CacheLock.class)) {
			CacheLock cacheLock = method.getAnnotation(CacheLock.class);
			// 获得方法中参数的注解
			Annotation[][] annotations = method.getParameterAnnotations();
			//获取方法中的参数
			Object[] args=method.getParameters();
			// 根据获取到的参数注解和参数列表获得加锁的参数
			Object lockedObject = getLockedObject(annotations, args);
			String objectValue = lockedObject.toString();

			// 设置锁的key
			redisLock.setKey(cacheLock.lockedPrefix(), objectValue);
			// 加锁
			boolean result = redisLock.lock(cacheLock.timeOut(), cacheLock.expireTime());
			if (!result) {// 取锁失败
				ERROR_COUNT += 1;
				logger.error("【redislock】取锁失败次数:"+ERROR_COUNT);
				throw new CacheLockException("get lock fail");
			}
			try {
				// 加锁成功，执行方法
				object = point.proceed();
			} finally {
				redisLock.unlock();// 释放锁
			}
		}
		else {
			object = point.proceed();
		}
		return object;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		CacheLock cacheLock = method.getAnnotation(CacheLock.class);
		// 没有cacheLock注解，pass
		if (null == cacheLock) {
			logger.error("【redislock】no cacheLock annotation");
			return method.invoke(proxy, args);
		}
		// 获得方法中参数的注解
		Annotation[][] annotations = method.getParameterAnnotations();
		// 根据获取到的参数注解和参数列表获得加锁的参数
		Object lockedObject = getLockedObject(annotations, args);
		String objectValue = lockedObject.toString();

		// 设置锁的key
		redisLock.setKey(cacheLock.lockedPrefix(), objectValue);
		// 加锁
		boolean result = redisLock.lock(cacheLock.timeOut(), cacheLock.expireTime());
		if (!result) {// 取锁失败
			ERROR_COUNT += 1;
			throw new CacheLockException("get lock fail");

		}
		try {
			// 加锁成功，执行方法
			return method.invoke(proxy, args);
		} finally {
			redisLock.unlock();// 释放锁
		}

	}

}
