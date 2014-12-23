package fr.albinpoignot.christmasgame;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Albin
 *
 */
public class PlayerChooser {

    private List<Player> playerList;

    public PlayerChooser() {

        try {
            String dir = System.getProperty("user.dir");
            BufferedReader br = new BufferedReader(
                    new FileReader(dir + "\\players.json"));

            Gson gson = new Gson();
            playerList = gson.fromJson(br, new TypeToken<List<Player>>(){}.getType());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Player getRandomPlayer() {
        Random random = new Random();
        Integer nextPlayerIndex = random.nextInt(playerList.size());
        return playerList.get(nextPlayerIndex);
    }

}
