package com.example.movies.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/movie/items")
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // Get controller methods
    @GetMapping
    public ResponseEntity<List<Item>> findAll(){ // Response entity is a helper class to fully describe the response
        List<Item> items = service.findAll();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> find(@PathVariable("id") Long id) {
        Optional<Item> item = service.find(id);
        return ResponseEntity.of(item);  // Shortcut for creating a ResponseEntity with either a valid body
                                         // and the 200 OK status, or no body and a 404 Not Found status.
    }
}
