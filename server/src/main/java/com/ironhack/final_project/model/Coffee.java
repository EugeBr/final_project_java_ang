package com.ironhack.final_project.model;

import com.ironhack.final_project.model.enums.Category;
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
    @Column(length = 1000)
    private String description;
    @NotEmpty(message = "PrepTime can't be empty")
    private String prepTime;
    @Column(length = 1000)
    private List<String> ingredients = new ArrayList<>();
    @Column(length = 1500)
    private List<String> instructions = new ArrayList<>();
    @Column(length = 1000)
    private String notes;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    public Coffee(String name, Category category, String description, String prepTime, List<String> ingredients, List<String> instructions, String notes, User createdBy) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.notes = notes;
        this.createdBy = createdBy;
    }

    public Coffee(String name, Category category, String imageUrl, String description, String prepTime, List<String> ingredients, List<String> instructions, String notes, User createdBy) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.description = description;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.notes = notes;
        this.createdBy = createdBy;
    }
}
