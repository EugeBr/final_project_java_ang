package com.ironhack.final_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CoffeeDTO {
    private Integer id;
    private String name;
    private Category category;
    private String imageUrl = "https://res.cloudinary.com/drrxks8d9/image/upload/v1685526907/Coffee/coffee-cup_q3izzc.png";
    @Column(length = 1000)
    private String description;
    private String prepTime;
    @Column(length = 1000)
    private List<String> ingredients = new ArrayList<>();
    @Column(length = 1500)
    private List<String> instructions = new ArrayList<>();
    @Column(length = 1000)
    private String notes;

    public CoffeeDTO(Coffee coffee) {
        this.id = coffee.getId();
        this.name = coffee.getName();
        this.category = coffee.getCategory();
        this.imageUrl = coffee.getImageUrl();
        this.description = coffee.getDescription();
        this.prepTime = coffee.getPrepTime();
        this.ingredients = coffee.getIngredients();
        this.instructions = coffee.getInstructions();
        this.notes = coffee.getNotes();
    }
}
