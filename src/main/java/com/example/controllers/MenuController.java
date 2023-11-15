package com.example.controllers;

import com.example.rockpaperscissorsjavafx.GameProcessor;
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

            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/GameScreen.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            GameProcessor gameProcessor = new GameProcessor(maxScoreValue);
            GameController gameController = loader.getController();

            gameController.valuesSetter();
            gameController.setGameProcessor(gameProcessor);
            gameController.setMainController(mainController);

            mainController.setMenuScreen(pane);

            gameController.nameSetter(playerName);
            gameProcessor.setMainController(mainController);
        } else {
            errorMessage.setText("Podaj Nazwę. min 3 znaki");
        }
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
