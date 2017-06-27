package com.pizz;

/**
 * @author huangdaye
 *定义Pizz的抽象类
 */
public abstract class Pizza {

	/**
	 * 定义制作Pizz准备方法
	 */
	public abstract void prepare();
	/**
	 * 定义制作Pizz烘烤方法
	 */
	public abstract void bake();
	/**
	 * 定义制作Pizz切片方法
	 */
	public abstract void cut();
	/**
	 * 定义制作Pizz装盒方法
	 */
	public abstract void box();
}
