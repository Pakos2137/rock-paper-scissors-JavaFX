package com.example.controllers;

import com.example.rockpaperscissorsjavafx.GameProcessor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameEndController {
    GameProcessor gameProcessor;
    MainController mainController;

    @FXML
    private Label score;
    @FXML
    private Label winText;
    public void gameEndValueSetter(int player,int computer) {
        score.setText(String.valueOf(player) + " : " + String.valueOf(computer));
        if(player > computer) {
            winText.setText("Wygrałeś");
        } else {
            winText.setText("Przegrałeś");
        }
    }
    @FXML
    private void backToMenu() {
        mainController.loadMenuScreen();
    }
    @FXML
    private void exit() {
        System.exit(0);
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
