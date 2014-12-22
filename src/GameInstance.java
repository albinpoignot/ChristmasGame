import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Albin
 *
 */
public class GameInstance implements Observer {
	
	private RandomTimeWaiter randomTimeWaiter;
	private MusicPlayer musicPlayer;
	
	public GameInstance() {
		System.out.println("Game instance created");
		randomTimeWaiter = new RandomTimeWaiter();
		randomTimeWaiter.addObserver(this);
		
		musicPlayer = new MusicPlayer();
		musicPlayer.addObserver(this);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable observable, Object arg) {
		System.out.println("Game instance received an update");
		if(observable instanceof RandomTimeWaiter) {
			System.out.println("RandomTimeWaiter ends");
			
			// TODO Ask for player
			
			musicPlayer.read();
		} else if(observable instanceof MusicPlayer) {
			System.out.println("MusicPlayer ends");
			startGame();
		}
	}
	
	public void startGame() {
		System.out.println("Game instance starts a game");
		randomTimeWaiter.start();
	}

}
