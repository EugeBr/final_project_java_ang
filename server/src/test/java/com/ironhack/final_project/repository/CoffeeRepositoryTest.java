package com.ironhack.final_project.repository;

import com.ironhack.final_project.model.Coffee;
import com.ironhack.final_project.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ironhack.final_project.model.enums.Category.COLD;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoffeeRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeeRepository coffeeRepository;

    @BeforeEach
    public void setUp() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_project", "root", "ironhack");

            Statement statement = connection.createStatement();

            String modDesc = "ALTER TABLE coffee MODIFY COLUMN description VARCHAR(1000)";
            String modNotes = "ALTER TABLE coffee MODIFY COLUMN notes VARCHAR(1000)";
            statement.executeUpdate(modDesc);
            statement.executeUpdate(modNotes);

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        User userTest = new User(null, "userTest", null, "bio", "password", null, null);
        userRepository.save(userTest);

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

        Coffee coffeeTest = new Coffee(
                null,
                "Boozy Whipped Coffee",
                COLD,
                "https://res.cloudinary.com/drrxks8d9/image/upload/v1685267552/Coffee/BackgroundEraser_20230528_115049487_xej40c.png",
                "What's better than fluffy, sweet whipped coffee over milk? Boozy whipped coffee, of course! This easy cocktail pairs coffee liqueur with milk, all topped with a little cloud of whipped coffee for an Instagram-worthy drink. Perfect for brunch or after dinner, and easy to make vegan.",
                "5 minutes",
                instructions1,
                steps1,
                "Use any sort of granulated sweetener in your whipped coffee, like sugar, coconut sugar, or granulated Swerve. We love whole milk in our whipped coffee because of how rich and delicious it makes the drink, but almond, coconut, oat, or whatever milk you have on hand is fine! For a vegan drink, just use non-dairy milk! We used Kahlúa in our drink, but you can use any coffee liqueur you like.",
                userTest);
        coffeeRepository.save(coffeeTest);
    }

    @AfterEach
    public void TearDown() {
        coffeeRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void findAll_coffee_coffeeList() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        System.out.println(coffeeList);
        assertEquals(1, coffeeList.size());
    }

    @Test
    public void findById_validId_correctCoffee() {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(1);
        assertTrue(coffeeOptional.isPresent());
        System.out.println(coffeeOptional.get());
        assertEquals("userTest", coffeeOptional.get().getCreatedBy().getUsername());
    }

    @Test
    public void findById_invalidId_coffeeNotPresent() {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(999);
        assertTrue(coffeeOptional.isEmpty());
    }
}