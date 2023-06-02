package com.ironhack.final_project.controller.interfaces;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;

import java.util.List;

public interface IUserController {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Integer id);
    void updateUser(User user, Integer id);
    void deleteUser(Integer id);
    //List<Coffee> getAllCoffeesByUserId(Integer id);
}
