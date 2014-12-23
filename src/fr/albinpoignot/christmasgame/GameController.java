package fr.albinpoignot.christmasgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {

    @FXML
    private Label nextPlayer;

    @FXML
    private Button stopMusic;

    @FXML
    private Button stopGame;

    @FXML
    private Button startGame;

    private Boolean isGameStarted = false;

    private RandomTimeWaiter randomTimeWaiter;
    private MusicPlayer musicPlayer;

    public GameController() {
        System.out.println("Game instance created");
        randomTimeWaiter = new RandomTimeWaiter();
        randomTimeWaiter.addObserver(this);

        musicPlayer = new MusicPlayer();
        musicPlayer.addObserver(this);
    }

    public void onStartButtonClick(ActionEvent actionEvent) {
        nextPlayer.setText("Reading...");
        startGame();
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable observable, Object arg) {
        System.out.println("Game instance received an update");
        if(isGameStarted) {
            if (observable instanceof RandomTimeWaiter) {
                System.out.println("RandomTimeWaiter ends");

                // TODO Ask for player

                musicPlayer.read();
            } else if (observable instanceof MusicPlayer) {
                System.out.println("MusicPlayer ends");
                startGame();
            }
        }
    }

    public void startGame() {
        System.out.println("Game instance starts a game");
        isGameStarted = true;
        randomTimeWaiter.start();
    }

    public void onStopGameButtonClick(ActionEvent actionEvent) {
        isGameStarted = false;
        musicPlayer.stop();
    }

    public void onStopSoundButtonClick(ActionEvent actionEvent) {
        System.out.println("Stop button clicked !");
        musicPlayer.stop();
    }
}
