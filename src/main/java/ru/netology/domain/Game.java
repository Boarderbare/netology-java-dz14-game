package ru.netology.domain;

import java.util.*;

public class Game {

    private Map<String, Integer> map = new HashMap<>();

    public void register(String name, int strenght) {
        map.put(name, strenght);
    }

    public Map<String, Integer> getAll() {
        return map;
    }

    public int round(String playerName1, String playerName2) {
        if (!map.containsKey(playerName1)) {
            throw new NotRegisteredException("This player " + playerName1 + "is not registered");
        }
        if (!map.containsKey(playerName2)) {
            throw new NotRegisteredException("This player " + playerName2 + "is not registered");
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
