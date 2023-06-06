package com.ironhack.userservice.controller.impl;

import com.ironhack.userservice.controller.interfaces.IUserController;
import com.ironhack.userservice.model.DTO.UserLoginDTO;
import com.ironhack.userservice.model.User;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.service.impl.UserService;
import org.springframework.web.bind.annotation.RestController;

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

    @PatchMapping("/users/login")
    @ResponseStatus(HttpStatus.OK)
    public User loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.loginUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }
}