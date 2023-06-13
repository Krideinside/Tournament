package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();

    @Test
    public void shouldTestWhenFirstPlayerWin() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        int expected = 1;
        int actual = game.round("Оля", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenSecondtPlayerWin() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        int expected = 2;
        int actual = game.round("Петя", "Оля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenDraw() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        int expected = 0;
        int actual = game.round("Петя", "Аня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenFirstPlayerNotRegistered() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Петя");
        });
    }

    @Test
    public void shouldTestWhenSecondPlayerNotRegistered() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Толя");
        });
    }

    @Test
    public void shouldTestWhenNameWithSmallSimbol() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("петя", "Аня");
        });
    }

    @Test
    public void shouldTestWhenNoOneRegistered() {
        game.register("Петя", 20);
        game.register("Аня", 20);
        game.register("Оля", 40);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Толя");
        });
    }
}