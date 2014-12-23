package fr.albinpoignot.christmasgame;
import java.util.Observable;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * @author Albin
 *
 */
public class MusicPlayer extends Observable {

	private MediaPlayer mediaPlayer;

	public void read() {

		System.out.println("MusicPlayer.read()");
		String bip = "file:///C:/sound.mp3";
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
		if(mediaPlayer != null) {
			System.out.println("Stopping...");
			mediaPlayer.stop();
		}
	}

}
