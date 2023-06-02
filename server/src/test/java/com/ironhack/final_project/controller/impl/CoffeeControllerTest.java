package com.ironhack.final_project.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import com.ironhack.final_project.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.final_project.model.enums.Category.COLD;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CoffeeControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void getAllCoffees_validRequest_allCoffees() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/coffees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Boozy"));
    }

    @Test
    void saveCoffee_validCoffee_coffeeSaved() throws Exception{
        User userTest = new User("userTest", "bio", "password");
        userRepository.save(userTest);

        List<String> instructions1 = new ArrayList<>();
        instructions1.add("Some ingredients");
        List<String> steps1 = new ArrayList<>();
        steps1.add("Some steps");

        Coffee coffee1 = new Coffee(
                "New Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685267552/Coffee/BackgroundEraser_20230528_115049487_xej40c.png",
                "This easy cocktail pairs coffee liqueur with milk, all topped with a little cloud of whipped coffee for an Instagram-worthy drink. Perfect for brunch or after dinner, and easy to make vegan.",
                "5 minutes",
                instructions1,
                steps1,
                "Use any sort of granulated sweetener in your whipped coffee, like sugar, coconut sugar, or granulated Swerve.",
                userTest);

        String body = objectMapper.writeValueAsString(coffee1);

        mockMvc.perform(post("/api/coffees").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/coffees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("New Coffee"));

        mockMvc.perform(delete("/api/coffees/2"))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void saveCoffee_invalidCoffee_notFoundCoffee() throws Exception{
        User userTest2 = new User("userTest", "bio", "password");
        userRepository.save(userTest2);

        List<String> instructions1 = new ArrayList<>();
        instructions1.add("Some ingredients");
        List<String> steps1 = new ArrayList<>();
        steps1.add("Some steps");

        Coffee coffee1 = new Coffee(
                "Boozy Whipped Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685267552/Coffee/BackgroundEraser_20230528_115049487_xej40c.png",
                "This easy cocktail pairs coffee liqueur with milk, all topped with a little cloud of whipped coffee for an Instagram-worthy drink. Perfect for brunch or after dinner, and easy to make vegan.",
                "5 minutes",
                instructions1,
                steps1,
                "Use any sort of granulated sweetener in your whipped coffee, like sugar, coconut sugar, or granulated Swerve.",
                userTest2);

        String body = objectMapper.writeValueAsString(coffee1);

        mockMvc.perform(post("/api/coffees").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andReturn();
    }

    @Test
    void getCoffeeById_validId_correctCoffee() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/coffees/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Boozy"));
    }

    @Test
    void getCoffeeById_invalidId_NotFound() throws Exception {
        mockMvc.perform(get("/api/coffees/99").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void deleteCoffee_coffeeDeleted() throws Exception{
        User userTest = new User("userTest", "bio", "password");
        userRepository.save(userTest);

        List<String> instructions1 = new ArrayList<>();
        instructions1.add("Some ingredients");
        List<String> steps1 = new ArrayList<>();
        steps1.add("Some steps");

        Coffee coffee1 = new Coffee(
                "New Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685267552/Coffee/BackgroundEraser_20230528_115049487_xej40c.png",
                "This easy cocktail pairs coffee liqueur with milk, all topped with a little cloud of whipped coffee for an Instagram-worthy drink. Perfect for brunch or after dinner, and easy to make vegan.",
                "5 minutes",
                instructions1,
                steps1,
                "Use any sort of granulated sweetener in your whipped coffee, like sugar, coconut sugar, or granulated Swerve.",
                userTest);

        String body = objectMapper.writeValueAsString(coffee1);

        mockMvc.perform(post("/api/coffees").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(delete("/api/coffees/2"))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/coffees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertFalse(mvcResult.getResponse().getContentAsString().contains("New Coffee"));
    }
}