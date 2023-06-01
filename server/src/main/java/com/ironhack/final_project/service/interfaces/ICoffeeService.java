package com.ironhack.final_project.service.interfaces;

import com.ironhack.final_project.model.Coffee;

public interface ICoffeeService {

    void saveCoffee(Coffee coffee);
    Coffee getCoffeeById(Integer id);
    void updateCoffee(Coffee coffee, Integer id);
    void deleteCoffee(Integer id);
}
