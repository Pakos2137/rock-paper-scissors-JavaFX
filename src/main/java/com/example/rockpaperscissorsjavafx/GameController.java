package com.example.rockpaperscissorsjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    private MainController mainController;
    @FXML
    private Label playerNameLabel;
    @FXML
    private void backToMenu() {
        mainController.loadMenuScreen();
    }
    @FXML
    private void scissors() {
        System.out.println("nożyce");
    }
    @FXML
    private void stone() {
        System.out.println("kamien");
    }
    @FXML
    private void paper() {
        System.out.println("papier");
    }
    public void startGame(String playerName,int maxValue) {
        playerNameLabel.setText(playerName + ":");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
