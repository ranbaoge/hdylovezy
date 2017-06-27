package com.store.Chicago;

import com.pizz.Pizza;
import com.pizz.Chicago.ChicagoStyleCheesePizza;
import com.pizz.Chicago.ChicagoStyleClamPizza;
import com.pizz.Chicago.ChicagoStylePepperoniPizza;
import com.pizz.Chicago.ChicagoStyleVegglePizza;
import com.store.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore{

	private Pizza pizza;
	@Override
	public Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if("cheese".equals(type)){
			pizza=new ChicagoStyleCheesePizza();
		}else if("clam".equals(type)){
			pizza=new ChicagoStyleClamPizza();
		}else if("veggle".equals(type)){
			pizza=new ChicagoStyleVegglePizza();
		}else if("pepperoni".equals(type)){
			pizza=new ChicagoStylePepperoniPizza();
		}
		
		return pizza;
	}

}
