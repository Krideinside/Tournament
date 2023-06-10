package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Player petya = new Player(1, "Петя", 20);
    Player anya = new Player(2, "Аня", 10);
    Player olya = new Player(3, "Оля", 40);

    @Test
    public void shouldTestWhenFirstPlayerWin() {
        Game game = new Game();

        game.register(petya);
        game.register(olya);

        int expected = 1;
        int actual = game.round("Оля", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenSecondPlayerWin() {
        Game game = new Game();

        game.register(petya);
        game.register(olya);

        int expected = 2;
        int actual = game.round("Петя", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenDraw() {
        Game game = new Game();

        game.register(petya);
        game.register(anya);

        int expected = 0;
        int actual = game.round("Петя", "Аня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenFirstPlayerNotRegistered() {
        Game game = new Game();

        game.register(petya);
        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Петя");
        });
    }

    @Test
    public void shouldTestWhenSecondPlayerNotRegistered() {
        Game game = new Game();

        game.register(petya);
        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Оля");
        });
    }

    @Test
    public void shouldTestWhenNameWithSmallSimbol() {
        Game game = new Game();

        game.register(petya);
        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("петя", "Аня");
        });
    }

    @Test
    public void shouldTestWhenNoOneRegistered() {
        Game game = new Game();

        game.register(petya);
        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Толя");
        });
    }
}