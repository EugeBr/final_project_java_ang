package com.ironhack.final_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@NotEmpty     unique?
    private String username;
    private String profilePicture = "https://res.cloudinary.com/drrxks8d9/image/upload/v1685526907/Coffee/coffee-cup_q3izzc.png";
    private String bio;
    private String password;

//    @OneToMany(fetch = EAGER)
//    private Collection<Coffee> coffeeList = new ArrayList<>();
//    @ManyToMany(fetch = EAGER)
//    private Collection<Coffee> favList = new ArrayList<>();

}
