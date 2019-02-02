package org.boluo.demo.common;

import org.boluo.utils.lock.RedisLockBase;

public class RedisLock extends RedisLockBase {

	private RedisCache<String> redisCache;

	public RedisLock() {

	}


	/**
	 * 加锁 使用方式为： lock(); try{ executeMethod(); }finally{ unlock(); }
	 * 
	 * @param timeout 轮询锁的时间范围
	 * @param expire 设置锁超时时间
	 * @return 成功 or 失败
	 */
	@Override
	public boolean lock(long timeout, int expire) {
		long nanoTime = System.nanoTime();
		timeout *= MILLI_NANO_TIME;
		try {
			// 在timeout的时间范围内不断轮询锁
			while (System.nanoTime() - nanoTime < timeout) {
				// 锁不存在的话，设置锁并设置锁过期时间，即加锁
				if (redisCache.get(this.key) == null) {
					redisCache.set(key, key, expire);
					//System.err.println("redislock key="+key);
					this.lock = true;
					return this.lock;
				}
				//System.out.println("出现锁等待");
				logger.info("【redislock】info:出现等待锁，key="+this.key);
				// 短暂休眠，避免可能的活锁
				Thread.sleep(3, RANDOM.nextInt(30));
			}
		} catch (Exception e) {
			throw new RuntimeException("locking error", e);
		}
		return false;
	}

	@Override
	public void unlock() {
		try {
			if (this.lock) {
				redisCache.delete(key);// 直接删除
			}
		} catch (Throwable e) {

		}
	}

	public void setRedisCache(RedisCache<String> redisCache) {
		this.redisCache = redisCache;
	}

}
