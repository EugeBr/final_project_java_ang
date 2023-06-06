package com.ironhack.userservice.service.interfaces;
import com.ironhack.userservice.model.User;

public interface IUserService {

    void saveUser(User user);
    User getUserById(Integer id);
    void updateUser(User user, Integer id);
    void deleteUser(Integer id);
    User loginUser(String username, String password);
}