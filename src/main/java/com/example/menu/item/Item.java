/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.menu.item;
import org.springframework.data.annotation.Id;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.*;

/**
 * Holds data for the restaurant menu - I guess this is called "boilerplate code"
 * I had to look up what a boilerplate is
 * @author austi
 */
public class Item {
    
    
    
    private final Long id;
    private final String name;
    @NotNull(message = "name is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "name must be a string")
    
    private final Long price;
    @NotNull(message = "price is required")
    @Positive(message = "price must be positive")
    
    private final String description;
    @NotNull(message = "description is required")
    
    @Pattern(regexp="^[a-zA-Z ]+$", message = "description must be a string")
    
    private final String image;
    @NotNull(message = "image is required")
    @URL(message = "image must be a URL")
    
    //There are other kinds of repositories, but this one stays in your memory, not someone else's
    
    public Item(Long id, String name, Long price, String description, String image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }
    
    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
    
    public Item updateWith(Item item) {
        return new Item(this.id, item.name, item.price, item.description, item.image);
    }
    
}
