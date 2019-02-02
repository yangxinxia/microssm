package org.boluo.utils.exception;

public class CacheLockException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7103953250946326383L;
	private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CacheLockException(String msg) {
        this.msg = msg;
    }

    public CacheLockException() {
    }
}
