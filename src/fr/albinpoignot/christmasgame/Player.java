package fr.albinpoignot.christmasgame;

/**
 * Created by Albin on 23/12/2014.
 */
public class Player {

    private String name;

    private String soundFile;

    private String soundTitle;

    public Player() {
        name = "";
        soundFile = "";
        soundTitle = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }

    public String getSoundTitle() {
        return soundTitle;
    }

    public void setSoundTitle(String soundTitle) {
        this.soundTitle = soundTitle;
    }
}
