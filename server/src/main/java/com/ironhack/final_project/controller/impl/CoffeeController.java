package com.ironhack.final_project.controller.impl;

import com.ironhack.final_project.controller.interfaces.ICoffeeController;
import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.repository.CoffeeRepository;
import com.ironhack.final_project.service.impl.CoffeeService;
import com.ironhack.final_project.service.interfaces.ICoffeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoffeeController implements ICoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    ICoffeeService coffeeService;

    @GetMapping("/coffees")
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    @PostMapping("/coffees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCoffee(@RequestBody @Valid Coffee coffee) {
        coffeeService.saveCoffee(coffee);
    }

    @GetMapping("/coffees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coffee getCoffeeById(@PathVariable Integer id) {
        return coffeeService.getCoffeeById(id);
    }

    @PutMapping("/coffees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoffee(@RequestBody Coffee coffee, @PathVariable Integer id) {
        coffeeService.updateCoffee(coffee, id);
    }

    @DeleteMapping("/coffees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoffee(@PathVariable Integer id) {
        coffeeService.deleteCoffee(id);
    }

    @GetMapping("/coffees/search?q={param}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> getAllCoffeesParam(@PathVariable String param) {
        return coffeeRepository.findAllByNameContaining(param);
    }
}
