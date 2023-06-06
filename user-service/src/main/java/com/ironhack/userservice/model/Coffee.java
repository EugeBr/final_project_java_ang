package com.ironhack.userservice.model;

import com.ironhack.userservice.model.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Category can't be null")
    private Category category;
    private String imageUrl = "https://res.cloudinary.com/drrxks8d9/image/upload/v1685526907/Coffee/coffee-cup_q3izzc.png";
    @NotEmpty(message = "Description can't be empty")
    private String description;
    @NotEmpty(message = "PrepTime can't be empty")
    private String prepTime;
    private List<String> ingredients = new ArrayList<>();
    private List<String> instructions = new ArrayList<>();
    private String notes;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

}