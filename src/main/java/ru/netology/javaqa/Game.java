package ru.netology.javaqa;

import java.util.HashMap;

public class Game {
    HashMap<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        map.put(player.name, player.strength);
    }

    public int round(String playerName1, String playerName2) {

        if (map.get(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (map.get(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (map.get(playerName1) > map.get(playerName2)) {
            return 1;
        }
        if (map.get(playerName1) < map.get(playerName2)) {
            return 2;
        }
        return 0;
    }
}