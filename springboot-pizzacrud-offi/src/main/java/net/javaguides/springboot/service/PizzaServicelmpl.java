package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Pizza;
import net.javaguides.springboot.repository.PizzaRepository;

@Service
public class PizzaServicelmpl implements PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	@Override
	public List<Pizza> getAllPizza(){
		return pizzaRepository.findAll();
	}
	@Override
	public void savePizza(Pizza pizza) {
		this.pizzaRepository.save(pizza);
		
	}
	@Override
	public Pizza getPizzaById(long id) {
		Optional<Pizza> optional = pizzaRepository.findById(id);
		Pizza pizza = null;
		if(optional.isPresent()) {
			pizza = optional.get();
		}else {
			throw new RuntimeException(" Pizza non trouvé pour id :: " + id);
		}
		return pizza;
	}
	@Override
	public void deletePizzaById(long id) {
		this.pizzaRepository.deleteById(id);
		
	}
}
