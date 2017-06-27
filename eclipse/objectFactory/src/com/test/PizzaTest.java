package com.test;

import org.junit.Test;

import com.pizz.Pizza;
import com.store.PizzaStore;
import com.store.Califonia.CalifoniaPizzaStore;

public class PizzaTest {

	private PizzaStore pizzaStore;
	private Pizza pizza;
	
	@Test
	public void Califonia(){
		pizzaStore=new CalifoniaPizzaStore();
		pizza=pizzaStore.orderPizza("veggle");
	}
}
