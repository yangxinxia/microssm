package org.boluo.utils.lock;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RedisLockBase {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	// 纳秒和毫秒之间的转换率
	public static final long MILLI_NANO_TIME = 1000 * 1000L;

	public static final String LOCKED = "TRUE";

	public static final Random RANDOM = new Random();
	protected String key;

	protected boolean lock = true;

	public String getKey() {
		return key;
	}

	public void setKey(String purpose,String key) {
		this.key = purpose + "_" + key + "_lock";
	}
	
	 public abstract boolean lock(long timeout,int expire);
	 
	 public abstract  void unlock();
}
