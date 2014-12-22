import javafx.embed.swing.JFXPanel;

/**
 * 
 */

/**
 * @author Albin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("----- Game launched");
		// Create a JFX Panel just to initialize JFX
		JFXPanel fxPanel = new JFXPanel();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				GameInstance gameInstance = new GameInstance();
				gameInstance.startGame();
			}
		};
		runnable.run();
		while(true);
		//System.out.println("----- Game stoped");
		
	}

}
