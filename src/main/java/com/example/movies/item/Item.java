package com.example.movies.item;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;

public class  Item {
    private final Long id;

    @NotNull(message="name is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "name must be a string")
    private final String name;

    @NotNull(message="genre is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "genre must be a string")
    private final String genre;

    @NotNull(message="description is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "description must be a string")
    private final String description;

    @NotNull(message="image is required")
    @URL(message = "image must be a URL")
    private final String image;

    public Item(Long id, String name, String genre, String description, String image) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Item updateWith(Item item){
        return new Item(
        this.id,
        item.name,
        item.genre,
        item.description,
        item.image
        );
    }
}
