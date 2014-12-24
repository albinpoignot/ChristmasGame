package fr.albinpoignot.christmasgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {

    @FXML
    private Label nextPlayerLabel;

    @FXML
    private Button stopMusic;

    @FXML
    private Button stopGame;

    @FXML
    private Button startGame;

    private Boolean isGameStarted = false;

    private RandomTimeWaiter randomTimeWaiter;
    private MusicPlayer musicPlayer;
    private PlayerChooser playerChooser;

    public GameController() {
        System.out.println("Game instance created");
        randomTimeWaiter = new RandomTimeWaiter();
        randomTimeWaiter.addObserver(this);

        musicPlayer = new MusicPlayer();
        musicPlayer.addObserver(this);

        playerChooser = new PlayerChooser();
    }

    public void onStartButtonClick(ActionEvent actionEvent) {
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

                Player nextPlayer = playerChooser.getRandomPlayer();
                //musicPlayer.read(nextPlayer);
                nextPlayerLabel.setText(nextPlayer.getName());
                nextPlayerLabel.setVisible(true);
            } else if (observable instanceof MusicPlayer) {
                System.out.println("MusicPlayer ends");
                nextPlayerLabel.setText("");
                nextPlayerLabel.setVisible(false);
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
        System.out.println("Stop GAME button clicked !");
        isGameStarted = false;
        musicPlayer.stop();
        nextPlayerLabel.setText("");
        nextPlayerLabel.setVisible(false);
    }

    public void onStopSoundButtonClick(ActionEvent actionEvent) {
        System.out.println("Stop MUSIC button clicked !");
        musicPlayer.stop();
        nextPlayerLabel.setText("");
        nextPlayerLabel.setVisible(false);
    }
}
