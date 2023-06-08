package com.ironhack.final_project.controller.interfaces;

import com.ironhack.final_project.controller.DTO.UserLoginDTO;
import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IUserController {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Integer id);
    void updateUser(User user, Integer id);
    void deleteUser(Integer id);
    List<Coffee> getAllCoffeesByUserId(Integer id);
    User loginUser(UserLoginDTO userLoginDTO);
    void addCoffeeToFav(Integer coffeeId, Integer userId);
    void removeCoffeeFromFav(Integer coffeeId, Integer userId);
}
