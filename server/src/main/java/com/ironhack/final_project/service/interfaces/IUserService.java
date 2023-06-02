package com.ironhack.final_project.service.interfaces;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;

import java.util.List;

public interface IUserService {

    void saveUser(User user);
    User getUserById(Integer id);
    void updateUser(User user, Integer id);
    void deleteUser(Integer id);
   // List<Coffee> getAllCoffeesByUserId(Integer id);
}
