package com.example.movies.item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    private List<Item> list;

    @Mock
    private CrudRepository<Item, Long> repository;

    @Mock
    private InMemoryItemRepository inMemoryItemRepository;

    @InjectMocks
    private ItemService itemService;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(new Item(1L, "Beverly Hills Chihuaha", "Comedy/Adventure/Drama", "Chloe, a Beverly Hills Chihuaha, enjoys her luxirious lifestyle, " +
                "hardly noticing Papi, a tough-looking Chihuaha who is head-over-paws for the pampered pooch. But when Choe gets lost in Mexico, Papi heads south to rescue" +
                "his true love.", "https://m.media-amazon.com/images/M/MV5BMTI2NzUxNjEzMl5BMl5BanBnXkFtZTcwOTMyNjM4MQ@@._V1_.jpg"));
        list.add(new Item(5L, "The Spectacular Now", "Romance/Drama", "Sutter, a spoilt young man, and Aimee, a studious girl, develop a special bond" +
                " and fall in love. However, they must overcome the challenges life throws their way, in order to stay together.",
                "https://m.media-amazon.com/images/M/MV5BMjA5MTc0NTkzM15BMl5BanBnXkFtZTcwODEwNjE3OQ@@._V1_.jpg"));
        list.add(new Item(6L, "Spider-Man: Into the Spider-Verse", "Family/Sci-fi", "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate " +
                "versions of himself and gets embroiled in an epic battle to save the multiverse.", "https://m.media-amazon.com/images/M/MV5BMjMwNDkxMTgzOF5BMl5BanBnXkFtZTgwNTkwNTQ3NjM@._V1_.jpg"));
    }

    @Test
    public void findAll() {
        given(itemService.findAll()).willReturn(Collections.checkedList(list, Item.class));

        assertThat(itemService.findAll(), notNullValue());
        assertThat(itemService.findAll(), is(list));
    }

    @Test
    public void find() {
        given(repository.findById(1L)).willReturn(Optional.of(list.get(0)));

        assertThat(itemService.find(1L), is(Optional.of(list.get(0))));
    }

    @Test
    public void create() {
    }


    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}