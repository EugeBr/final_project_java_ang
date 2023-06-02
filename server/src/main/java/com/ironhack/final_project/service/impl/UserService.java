package com.ironhack.final_project.service.impl;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import com.ironhack.final_project.repository.CoffeeRepository;
import com.ironhack.final_project.repository.UserRepository;
import com.ironhack.final_project.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    public void saveUser(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        if (userOptional.isPresent()) {throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "This username already exist");}
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> UserOptional = userRepository.findById(id);
        if (UserOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found");
        return UserOptional.get();
    }

    @Override
    public void updateUser(User user, Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User" + id + "not found");
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User" + id + "not found");
        userRepository.deleteById(id);
    }

//    @Override
//    public List<Coffee> getAllCoffeesByUserId(Integer id) {
//        Optional<User> UserOptional = userRepository.findById(id);
//        if (UserOptional.isEmpty())
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found");
//        return coffeeRepository.findAllByCreatedBy(id);
//    }

}
