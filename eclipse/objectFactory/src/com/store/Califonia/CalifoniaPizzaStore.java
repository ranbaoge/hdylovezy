package com.store.Califonia;

import com.pizz.Pizza;
import com.pizz.California.CalifoniaStyleClamPizza;
import com.pizz.California.CalifoniaStylePepperoniPizza;
import com.pizz.California.CalifoniaStyleVegglePizza;
import com.pizz.California.CaliforniaStyleCheesePizza;
import com.store.PizzaStore;

public class CalifoniaPizzaStore extends PizzaStore{

	private Pizza pizza;
	@Override
	public Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if("cheese".equals(type)){
			pizza=new CaliforniaStyleCheesePizza();
		}else if("clam".equals(type)){
			pizza=new CalifoniaStyleClamPizza();
		}else if("veggle".equals(type)){
			pizza=new CalifoniaStyleVegglePizza();
		}else if("pepperoni".equals(type)){
			pizza=new CalifoniaStylePepperoniPizza();
		}
		
		return pizza;
	}

}
