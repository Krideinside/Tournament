package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    Player petya = new Player(1, "Петя", 20);
    Player anya = new Player(2, "Аня", 20);
    Player olya = new Player(3, "Оля", 40);


    @Test
    public void shouldTestWhenFirstPlayerWin() {
        game.register(petya);
        game.register(olya);

        int expected = 1;
        int actual = game.round("Оля", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenSecondtPlayerWin() {
        game.register(petya);
        game.register(olya);

        int expected = 2;
        int actual = game.round("Петя", "Оля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenDraw() {
        game.register(petya);
        game.register(anya);

        int expected = 0;
        int actual = game.round("Петя", "Аня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenFirstPlayerNotRegistered() {
        game.register(petya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Петя");
        });
    }

    @Test
    public void shouldTestWhenSecondPlayerNotRegistered() {
        game.register(petya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Толя");
        });
    }

    @Test
    public void shouldTestWhenNameWithSmallSimbol() {
        game.register(petya);
        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("петя", "Аня");
        });
    }

    @Test
    public void shouldTestWhenNoOneRegistered() {
        game.register(petya);
        game.register(anya);
        game.register(olya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Толя");
        });
    }
}