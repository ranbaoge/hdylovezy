package com.store;

import com.pizz.Pizza;

/**
 * @author huangdaye
 *定义PizzStore的抽象类
 */
public abstract class PizzaStore {

	private Pizza pizza;
	
	/**
	 * 获取Pizza订单的方法
	 * @param type
	 * @return
	 */
	public Pizza orderPizza(String type){
		pizza=createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
	//定义特定Pizza的抽象类
	public abstract Pizza createPizza(String type);
	
}
