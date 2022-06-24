package ru.netology.domain;

import java.util.*;

public class Game {

    private Map<String, Player> map = new HashMap<>();

    public void register(String name, Player player) {
        map.put(name, player);
    }

    public Map<String, Player> getAll() {
        return map;
    }

    public int round(String playerName1, String playerName2) {
        if (!map.containsKey(playerName1)) {
            throw new NotRegisteredException("This player " + playerName1 + "is not registered");
        }
        if (!map.containsKey(playerName2)) {
            throw new NotRegisteredException("This player " + playerName2 + "is not registered");
        }

        if (map.get(playerName1).getStrength() > map.get(playerName2).getStrength()) {
            return 1;
        }
        if (map.get(playerName1).getStrength() < map.get(playerName2).getStrength()) {
            return 2;
        }
        return 0;
    }
}
