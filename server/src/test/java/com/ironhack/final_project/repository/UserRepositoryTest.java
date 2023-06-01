package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @BeforeEach
    public void setUp() {

        User userTest = new User("userTest", "bio", "password");
        userRepository.save(userTest);
    }

    @AfterEach
    public void TearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void findAll_user_userList() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
        assertEquals(1, userList.size());
    }

    @Test
    public void findById_validId_correctUser() {
        Optional<User> userOptional = userRepository.findById(1);
        assertTrue(userOptional.isPresent());
        System.out.println(userOptional.get());
        assertEquals("userTest", userOptional.get().getUsername());
    }

    @Test
    public void findById_invalidId_userNotPresent() {
        Optional<User> userOptional = userRepository.findById(999);
        assertTrue(userOptional.isEmpty());
    }

    @Test
    public void findByUsername_validUsername_correctUser() {
        Optional<User> userOptional = userRepository.findByUsername("userTest");
        assertTrue(userOptional.isPresent());
        System.out.println(userOptional.get());
        assertEquals("bio", userOptional.get().getBio());
    }
}