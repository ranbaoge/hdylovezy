package com.store.Chinese;

import com.pizz.Pizza;
import com.pizz.Chinese.ChineseStyleCheesePizza;
import com.pizz.Chinese.ChineseStyleClamPizza;
import com.pizz.Chinese.ChineseStylePepperoniPizza;
import com.pizz.Chinese.ChinsesStyleVegglePizza;
import com.store.PizzaStore;

public class ChinsesPizzaStore extends PizzaStore{

	private Pizza pizza;
	@Override
	public Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if("cheese".equals(type)){
			pizza=new ChineseStyleCheesePizza();
		}else if("clam".equals(type)){
			pizza=new ChineseStyleClamPizza();
		}else if("veggle".equals(type)){
			pizza=new ChinsesStyleVegglePizza();
		}else if("pepperoni".equals(type)){
			pizza=new ChineseStylePepperoniPizza();
		}
		
		return pizza;
	}

}
