package com.example.movies.item;

import org.springframework.data.annotation.Id;

public class  Item {
    private final Long id;
    private final String name;
    private final String genre;
    private final String description;
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
