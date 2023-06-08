package com.ironhack.final_project.controller.impl;

import com.ironhack.final_project.controller.DTO.UserLoginDTO;
import com.ironhack.final_project.controller.interfaces.IUserController;
import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import com.ironhack.final_project.repository.UserRepository;
import com.ironhack.final_project.service.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController implements IUserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody @Valid User user, @PathVariable Integer id) {
        userService.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}/coffees")
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> getAllCoffeesByUserId(@PathVariable Integer id) {
        return userService.getAllCoffeesByUserId(id);
    }

    @PatchMapping("/users/login")
    @ResponseStatus(HttpStatus.OK)
    public User loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.loginUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PatchMapping("users/addfav")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCoffeeToFav(
            @RequestParam Integer coffeeId,
            @RequestParam Integer userId
    ) {
        userService.saveFavorite(coffeeId, userId);
        System.out.println("adding favorite");
    }

    @PatchMapping("users/removefav")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCoffeeFromFav(
            @RequestParam Integer coffeeId,
            @RequestParam Integer userId
    ) {
        userService.removeFavorite(coffeeId, userId);
    }
}


