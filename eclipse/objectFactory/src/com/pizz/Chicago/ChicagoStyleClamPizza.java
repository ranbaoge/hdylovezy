package com.pizz.Chicago;

import com.pizz.Pizza;

public class ChicagoStyleClamPizza extends Pizza{
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("开始制作Chicago风味的ClamPizza");
	}

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("烘烤22分钟");
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("切成1.3cm的小片");
	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("包装上Chicago的Clam风味的盒子");
	}
}
