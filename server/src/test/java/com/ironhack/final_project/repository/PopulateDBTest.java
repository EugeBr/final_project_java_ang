package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.final_project.model.enums.Category.COLD;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PopulateDBTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        coffeeRepository.deleteAll();

        User user1 = new User("user1", "bio", "password");
        userRepository.save(user1);

        List<String> instructions1 = new ArrayList<>();
        instructions1.add("2 tablespoons hot water");
        instructions1.add("2 tablespoons instant coffee");
        instructions1.add("2 tablespoons sweetener");
        instructions1.add("1/2 cup milk");
        instructions1.add("1/4 cup Kahlúa");
        instructions1.add("ice");
        List<String> steps1 = new ArrayList<>();
        steps1.add("Add water, coffee, and sweetener to bowl and whip on medium to high speed or whisk.");
        steps1.add("Fill glass with ice, pour Kahlúa in, then milk. Top with a dollop of whipped coffee.");

        Coffee coffee1 = new Coffee(
                "Boozy Whipped Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685267552/Coffee/BackgroundEraser_20230528_115049487_xej40c.png",
                "This easy cocktail pairs coffee liqueur with milk, all topped with a little cloud of whipped coffee for an Instagram-worthy drink. Perfect for brunch or after dinner, and easy to make vegan.",
                "5 minutes",
                instructions1,
        steps1,
        "Use any sort of granulated sweetener in your whipped coffee, like sugar, coconut sugar, or granulated Swerve.",
        user1);
        coffeeRepository.save(coffee1);
    }

    @Test
    public void findAll_allEntities_AllTheLists() {
        List<User> userList = userRepository.findAll();
        List<Coffee> coffeeList = coffeeRepository.findAll();

        System.out.println(userList);
        System.out.println(coffeeList);

        assertEquals(1, userList.size());
        assertEquals(1, coffeeList.size());
    }
}

