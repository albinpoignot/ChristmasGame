import java.util.Observable;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
/**
 * 
 */

/**
 * @author Albin
 *
 */
public class MusicPlayer extends Observable {

	public void read() {
		new Runnable() {
			
			@Override
			public void run() {
				System.out.println("MusicPlayer.read()");
				String bip = "file:///C:/sound.mp3";
				Media hit = new Media(bip);
				MediaPlayer mediaPlayer = new MediaPlayer(hit);
				
				//ReadOnlyObjectProperty<Duration> duration = mediaPlayer.totalDurationProperty();
				
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
		}.run();
		
		
		/*Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Music player starts to read");
				
				
				
				//while(mediaPlayer.)
				
				/*try {
					Thread.sleep((long) (5 * 1000));
					setChanged();
					notifyObservers();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			/*}
		};*/
		
		//runnable.run();
	}

}
