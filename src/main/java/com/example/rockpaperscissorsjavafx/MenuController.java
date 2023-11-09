package com.example.rockpaperscissorsjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {
    private MainController mainController;
    @FXML
    private Slider maxScore;
    @FXML
    private TextField nameField;
    @FXML
    private Label errorMessage;
    private String playerName;
    private int maxScoreValue;
    @FXML
    public void setMaxScoreValue(ActionEvent event) {
        if(nameField.getText().length() >= 3 && nameField.getText() != null) {

            playerName = nameField.getText();
            maxScoreValue = (int)maxScore.getValue();
            System.out.println(maxScoreValue);
            System.out.println(playerName);

            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/GameScreen.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            GameController gameController = loader.getController();
            gameController.setMainController(mainController);
            mainController.setMenuScreen(pane);
            gameController.startGame(playerName,maxScoreValue);
        } else {
            errorMessage.setText("Podaj Nazwę. min 3 znaki");
        }
    }
    public String getPlayerName() {
        return playerName;
    }
    public int getMaxScoreValue() {
        return maxScoreValue;
    }
    public void setMaxScoreValue(int maxScoreValue) {
        this.maxScoreValue = maxScoreValue;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
