package com.pizz.California;

import com.pizz.Pizza;

/**
 * @author huangdaye
 * 定义加里佛利亚风味得到Pizza
 */
public class CaliforniaStyleCheesePizza extends Pizza{

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("开始制作California风味的CheesePizza");
	}

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("烘烤30分钟");
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("切成2cm的小片");
	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("包装上California的Cheese风味的盒子");
	}

}
