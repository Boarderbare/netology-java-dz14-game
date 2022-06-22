package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    List<Player> players = new ArrayList<>();
    public Game game = new Game();

    @BeforeEach
    public void setup() {
        game.registerAll(List.of(new Player(1, "Ilya", 3),
                new Player(2, "Petya", 4),
                new Player(3, "Vanya", 1),
                new Player(4, "Kolya", 6),
                new Player(5, "Vasya", 4)));
    }

//    @Test
//    public void shouldRegisterOne() {
//        boolean actual = game.register(new Player(1, "Ilya", 3));
//        boolean expected =true;
//        assertEquals(expected,actual);
//    }

    @Test
    public void shouldRegisterAll() {
        List<Player> actual = game.getAll();
        List<Player> expected = new ArrayList<Player>(List.of(
                new Player(1, "Ilya", 3),
                new Player(2, "Petya", 4),
                new Player(3, "Vanya", 1),
                new Player(4, "Kolya", 6),
                new Player(5, "Vasya", 4)));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecond() {
        int actual = game.round("Vanya", "Ilya");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFirst() {

        int actual = game.round("Kolya", "Petya");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldStandOff() {
        int actual = game.round("Vasya", "Petya");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNoRegister() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Zhenya");
        });
    }

}