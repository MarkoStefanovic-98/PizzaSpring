package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Pizza;
import net.javaguides.springboot.service.PizzaService;


@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	//Affiche liste pizza
	@GetMapping("/")
	public String viewHomePage (Model model) {
		model.addAttribute("listPizza", pizzaService.getAllPizza());
		return "index";
	}
	
	@GetMapping("/showNewPizzaForm")
	public String showNewPizzaForm(Model model) {
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		return "new_pizza";
	}
	
	@PostMapping("/savePizza")
	public String savePizza(@ModelAttribute("pizza") Pizza pizza) {
		// ajout de la pizza dans la BDD
		pizzaService.savePizza(pizza);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		Pizza pizza = pizzaService.getPizzaById(id);
		
		model.addAttribute("pizza", pizza);
		return "update_pizza";
	}
	
	@GetMapping("/deletePizza/{id}")
	public String deletePizza(@PathVariable (value = "id") long id) {
		
		this.pizzaService.deletePizzaById(id);
		return "redirect:/";
	}
}
