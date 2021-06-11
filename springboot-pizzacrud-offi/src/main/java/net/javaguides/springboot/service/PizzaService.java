package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Pizza;

public interface PizzaService {
	List<Pizza> getAllPizza();
	void savePizza(Pizza pizza);
	Pizza getPizzaById(long id);
	void deletePizzaById(long id);
}
