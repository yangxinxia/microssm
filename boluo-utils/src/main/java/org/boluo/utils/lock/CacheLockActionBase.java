package org.boluo.utils.lock;

import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.boluo.utils.exception.CacheLockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CacheLockActionBase  {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	public static int ERROR_COUNT = 0;
	
	
	/**
	 * 定义切面，使用注解CacheLock注解的方法都会被拦截
	 */
	@Pointcut("@annotation(org.boluo.utils.lock.CacheLock)")
	public void cutService() {

	}
	
	public abstract Object around(ProceedingJoinPoint point)throws Throwable;
	
	/**
	 * 
	 * @param annotations
	 * @param args
	 * @return
	 * @throws CacheLockException
	 */
	protected Object getLockedObject(Annotation[][] annotations, Object[] args) throws CacheLockException {
		if (null == args || args.length == 0) {
			throw new CacheLockException("方法参数为空，没有被锁定的对象");
		}

		if (null == annotations || annotations.length == 0) {
			throw new CacheLockException("没有被注解的参数");
		}
		// 不支持多个参数加锁，只支持第一个注解为lockedObject或者lockedComplexObject的参数
		int index = -1;// 标记参数的位置指针
		for (int i = 0; i < annotations.length; i++) {
			for (int j = 0; j < annotations[i].length; j++) {
				if (annotations[i][j] instanceof LockedComplexObject) {// 注解为LockedComplexObject
					index = i;
					try {
						return args[i].getClass().getField(((LockedComplexObject) annotations[i][j]).field());
					} catch (NoSuchFieldException | SecurityException e) {
						throw new CacheLockException("注解对象中没有该属性" + ((LockedComplexObject) annotations[i][j]).field());
					}
				}

				if (annotations[i][j] instanceof LockedObject) {
					index = i;
					break;
				}
			}
			// 找到第一个后直接break，不支持多参数加锁
			if (index != -1) {
				break;
			}
		}

		if (index == -1) {
			throw new CacheLockException("请指定被锁定参数");
		}

		return args[index];
	}

}
