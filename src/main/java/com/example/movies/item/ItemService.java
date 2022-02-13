package com.example.movies.item;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@EnableMapRepositories
public class ItemService {

    private final CrudRepository<Item, Long> repository;

    public ItemService(CrudRepository<Item, Long> repository) {
        this.repository = repository;

        // Populate the in-memory store
        this.repository.saveAll(defaultItems());
    }

    // List of Movie Items
    private static List<Item> defaultItems(){
        return List.of(
                new Item(1L, "Beverly Hills Chihuaha", "Comedy/Adventure/Drama", "Chloe, a Beverly Hills Chihuaha, enjoys her luxirious lifestyle, " +
                        "hardly noticing Papi, a tough-looking Chihuaha who is head-over-paws for the pampered pooch. But when Choe gets lost in Mexico, Papi heads south to rescue" +
                        "his true love.", "https://m.media-amazon.com/images/M/MV5BMTI2NzUxNjEzMl5BMl5BanBnXkFtZTcwOTMyNjM4MQ@@._V1_.jpg"),
                new Item(2L, "The Spectacular Now", "Romance/Drama", "Sutter, a spoilt young man, and Aimee, a studious girl, develop a special bond" +
                        " and fall in love. However, they must overcome the challenges life throws their way, in order to stay together.",
                        "https://m.media-amazon.com/images/M/MV5BMjA5MTc0NTkzM15BMl5BanBnXkFtZTcwODEwNjE3OQ@@._V1_.jpg"),
                new Item(3L, "Spider-Man: Into the Spider-Verse", "Family/Sci-fi", "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate " +
                        "versions of himself and gets embroiled in an epic battle to save the multiverse.", "https://m.media-amazon.com/images/M/MV5BMjMwNDkxMTgzOF5BMl5BanBnXkFtZTgwNTkwNTQ3NjM@._V1_.jpg")
        );
    }

    public List<Item> findAll(){
        List<Item> list = new ArrayList<>();
        Iterable<Item> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public Optional<Item> find(Long id){
        return repository.findById(id);
    }

    public Item create(Item item) {
        // To ensure the item ID remains unique use the current timestamp.
        Item copy = new Item(
                new Date().getTime(),
                item.getName(),
                item.getGenre(),
                item.getDescription(),
                item.getImage()
        );
    return repository.save(copy);
    }

    public Optional<Item> update(Long id, Item newItem) {
        // Only update an item if it can be found first.
        return repository.findById(id)
                .map(oldItem -> {
                    Item updated = oldItem.updateWith(newItem);
                    return repository.save(updated);
                });
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
