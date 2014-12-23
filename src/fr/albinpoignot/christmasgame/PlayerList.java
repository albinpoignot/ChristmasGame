package fr.albinpoignot.christmasgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albin on 23/12/2014.
 */
public class PlayerList {

    private List<Player> playerList;

    public PlayerList() {
        playerList = new ArrayList<Player>();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
