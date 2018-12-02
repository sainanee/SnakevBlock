package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller class for Play/Resume Page
 */
public class PlayPageController {


    @FXML
    private Button resume;
    @FXML
    private Button start;
    @FXML
    private AnchorPane mainframe;
    private Main runningGame;
    private Player current_player;


    /**
     * Setter for runningGame
     *
     * @param runningGame
     */
    public void setRunningGame(Main runningGame) {
        this.runningGame = runningGame;
    }

    /**
     * Function to resume game
     * @param actionEvent
     */
    public void resumeGame(ActionEvent actionEvent) {
        String dataFile = current_player.getUsername();
        dataFile += "database.ser";
        runningGame = Main.deserialize(dataFile);
        if (runningGame == null) return;
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        try {
            runningGame.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to start new game
     * @param actionEvent
     */
    public void startGame(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        runningGame = new Main();
        System.out.println(3);
        try {
            Stage stage = new Stage();
            System.out.println(current_player.getUsername());
            current_player.setPane(runningGame.mainframe);
            System.out.println(runningGame.mainframe.getChildren().size());
            runningGame.setP(current_player);
            runningGame.start(stage);
            System.out.println("checker");
            runningGame.renewGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Setter for current_player
     * @param current_player
     */
    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
    }
}
