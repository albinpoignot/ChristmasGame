import java.util.Observable;
import java.util.Random;

/**
 * 
 */

/**
 * @author Albin
 *
 */
public class RandomTimeWaiter extends Observable {

	/**
	 * Start the timer for a Random time, then notify the observers when the count ends
	 */
	public void start() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Random random = new Random();
				int randomInt = random.nextInt(10);
				randomInt = 1;
				System.out.println("Waiting a random time : " + randomInt);
				try {
					Thread.sleep((long)(randomInt * 1000));
					setChanged();
					notifyObservers();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		runnable.run();
	}
	
}
