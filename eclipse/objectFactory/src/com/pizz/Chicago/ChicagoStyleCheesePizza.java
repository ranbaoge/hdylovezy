package com.pizz.Chicago;

import com.pizz.Pizza;

public class ChicagoStyleCheesePizza extends Pizza{

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("开始制作Chicago风味的CheesePizza");
	}

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("烘烤40分钟");
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("切成4.5cm的小片");
	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("包装上Chicago的Cheese风味的盒子");
	}
}
