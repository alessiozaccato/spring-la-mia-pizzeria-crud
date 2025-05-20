package com.java.lessons.crud1.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.lessons.crud1.spring_la_mia_pizzeria_crud.model.Pizza;
import com.java.lessons.crud1.spring_la_mia_pizzeria_crud.repositories.PizzaRepository;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model){
        List <Pizza> pizzas= repository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model){
        Pizza pizza= repository.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "pizzas/show";
    }
}
