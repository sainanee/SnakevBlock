package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private Button signin;
    @FXML
    private Button signup;
    @FXML
    private AnchorPane mainframe;
    private String input_username;

    public void make_account(ActionEvent actionEvent) {
        try {
            Scene sc = new Scene((AnchorPane) FXMLLoader.load(getClass().getResource("Make_Account.fxml")));
            sc.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
            ((Stage) mainframe.getScene().getWindow()).setScene(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(ActionEvent actionEvent) {
        input_username = username.getText();
        try {
            Scene sc = new Scene((AnchorPane) FXMLLoader.load(getClass().getResource("Main_Page.fxml")));
            sc.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
            ((Stage) mainframe.getScene().getWindow()).setScene(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
