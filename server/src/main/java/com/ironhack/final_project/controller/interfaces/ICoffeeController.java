package com.ironhack.final_project.controller.interfaces;

import com.ironhack.final_project.model.Coffee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICoffeeController {

    List<Coffee> getAllCoffees();
    void saveCoffee(Coffee coffee);
    Coffee getCoffeeById(Integer id);
    void updateCoffee(Coffee coffee, Integer id);
    void deleteCoffee(Integer id);
    List<Coffee> getAllCoffeesParam(String param);
    Coffee getRandomCoffee();
}
