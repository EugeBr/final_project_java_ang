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
   // @NotEmpty
    private String username;
    private String profilePicture = "https://res.cloudinary.com/drrxks8d9/image/upload/v1685526907/Coffee/coffee-cup_q3izzc.png";
  //  @NotEmpty
    private String bio;
  //  @NotEmpty
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE)
    private Collection<Coffee> favList = new ArrayList<>();

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
}
