package com.wangjie.jdbc.mybatis.type;

/**
 * @author wangjie
 */
public enum Enabled {
	/**
	 * 开启
	 */
	enabled(1), //启用
	/**
	 * 禁用
	 */
	disabled(0);//禁用
	
	private final int value;

	private Enabled(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
