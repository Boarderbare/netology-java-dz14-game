package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

//    public boolean register(Player player) {
//        return players.add(player);
//    }
    public boolean registerAll(Collection<? extends Player> players){
        return this.players.addAll(players);
    }
    public List<Player> getAll(){
        return players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (name == player.getName()) {
                return player;
            }
        }
        throw new NotRegisteredException("This player " + name + "is not registered");
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        }
        return 0;
    }
}
