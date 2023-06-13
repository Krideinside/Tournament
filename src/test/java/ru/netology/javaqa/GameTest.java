package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class GameTest {
    Game game = new Game();

    @Test
    public void shouldTestWhenFirstPlayerWin() {
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        int expected = 1;
        int actual = game.round("Оля", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenSecondtPlayerWin() {
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        int expected = 2;
        int actual = game.round("Петя", "Оля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenDraw() {
        HashMap<String, Integer> map = new HashMap<>();
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        int expected = 0;
        int actual = game.round("Петя", "Аня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenFirstPlayerNotRegistered() {
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Петя");
        });
    }

    @Test
    public void shouldTestWhenSecondPlayerNotRegistered() {
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Толя");
        });
    }

    @Test
    public void shouldTestWhenNameWithSmallSimbol() {
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("петя", "Аня");
        });
    }

    @Test
    public void shouldTestWhenNoOneRegistered() {
        game.registerPetya();
        game.registerOlya();
        game.registerAnya();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Толя");
        });
    }
}