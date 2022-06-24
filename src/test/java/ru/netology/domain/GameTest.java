package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Map<String, Integer> map = new HashMap<>();
    public Game game = new Game();

    @BeforeEach
    public void setup() {

        game.register("Ilya", new Player(1, "Ilya", 3));
        game.register("Petya", new Player(2, "Petya", 4));
        game.register("Vanya", new Player(3, "Vanya", 1));
        game.register("Kolya", new Player(4, "Kolya", 6));
        game.register("Vasya", new Player(5, "Vasya", 4));
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