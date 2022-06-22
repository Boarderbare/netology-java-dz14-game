package ru.netology.domain;

import java.util.*;

public class Game {

    private Map<String,Integer> map = new HashMap<>();

    public void register(String name, int strenght) {
        map.put(name, strenght);
    }

    public Map<String, Integer> getAll(){
        return map;
    }

    public int findByName(String name) {
        for (String key : map.keySet()) {
            if (key.equals(name)){
                return map.get(key);
            }
        }
        throw new NotRegisteredException("This player " + name + "is not registered");
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) > findByName(playerName2)) {
            return 1;
        }
        if (findByName(playerName1) < findByName(playerName2)) {
            return 2;
        }
        return 0;
    }
}
