package fr.albinpoignot.christmasgame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Observable;

/**
 * @author Albin
 */
public class MusicPlayer extends Observable {

    private MediaPlayer mediaPlayer;

    public void read(Player player) {

        System.out.println("MusicPlayer.read()");
        String bip = player.getSoundFile();
        Media hit = new Media(bip);
        mediaPlayer = new MediaPlayer(hit);

        System.out.println("MusicPlayer actually starts playing");
        mediaPlayer.play();

        Runnable notifyingRunnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Something happened on notifyingRunnable");
                MusicPlayer.this.setChanged();
                MusicPlayer.this.notifyObservers();
            }
        };

        Runnable errorRunnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("ERROR !");
            }
        };

        mediaPlayer.setOnHalted(notifyingRunnable);
        mediaPlayer.setOnEndOfMedia(notifyingRunnable);
        mediaPlayer.setOnStopped(notifyingRunnable);
        mediaPlayer.setOnError(errorRunnable);
    }

    public void stop() {
        System.out.println("Stop asked !");
        if (mediaPlayer != null) {
            System.out.println("Stopping...");
            mediaPlayer.stop();
        }
    }

}
