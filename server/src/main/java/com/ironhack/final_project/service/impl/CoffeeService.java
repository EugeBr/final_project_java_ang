package com.ironhack.final_project.service.impl;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.repository.CoffeeRepository;
import com.ironhack.final_project.service.interfaces.ICoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CoffeeService implements ICoffeeService {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    public void saveCoffee(Coffee coffee) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findByName(coffee.getName());
        if(coffeeOptional.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Coffee already exists");
        coffeeRepository.save(coffee);
    }

    @Override
    public Coffee getCoffeeById(Integer id) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if(coffeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee" + id + "not found");
        return coffeeOptional.get();
    }

    @Override
    public void updateCoffee(Coffee coffee, Integer id) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if(coffeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee" + id + "not found");
        coffee.setId(id);
        coffeeRepository.save(coffee);
    }

    @Override
    public void deleteCoffee(Integer id) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if(coffeeOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Coffee" + id + "not found");
        coffeeRepository.deleteById(id);
    }

    @Override
    public Coffee getRandomCoffee() {
        Random random = new Random();
        int index = random.nextInt((int) coffeeRepository.count());
        List<Coffee> coffeeList = coffeeRepository.findAll();
        return coffeeList.get(index);
    }
}
