package com.ironhack.final_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotEmpty(message = "Username can't be empty")
    private String username;
    private String profilePicture = "https://res.cloudinary.com/drrxks8d9/image/upload/v1660934322/find-a-market/xsiwpbh1lmqtgof0ebkl.jpg";
//    @NotEmpty(message = "Bio can't be empty")
    private String bio;
//    @NotEmpty(message = "password can't be empty")
    private String password;
    @ElementCollection
    private Collection<CoffeeDTO> favList = new ArrayList<>();

    public User(String username, String profilePicture, String bio, String password) {
        this.username = username;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.password = password;
    }

    public User(String username, String bio, String password) {
        this.username = username;
        this.bio = bio;
        this.password = password;
    }

    public void saveFav(Coffee coffee) {
        this.favList.add(new CoffeeDTO(coffee));
    }

    public void removeFav(Coffee coffee) {
        this.favList.remove(new CoffeeDTO(coffee));
    }
}
