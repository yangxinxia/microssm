package org.boluo.utils.wrapper;

import java.io.Serializable;

/**
 * 排序基本类
 */
public class SortVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String property;
	private String direction;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
