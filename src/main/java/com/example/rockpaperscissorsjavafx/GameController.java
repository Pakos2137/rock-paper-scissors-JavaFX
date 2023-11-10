package com.example.rockpaperscissorsjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    GameProcessor gameProcessor;
    private MainController mainController;
    @FXML
    private Label playerNameLabel;
    @FXML
    private Label computerScoreLabel;
    @FXML
    private Label playerScoreLabel;
    @FXML
    private void backToMenu() {
        mainController.loadMenuScreen();
    }
    @FXML
    private void scissors() {
        gameProcessor.takeMove('S');
    }
    @FXML
    private void rock() {
        gameProcessor.takeMove('R');
    }
    @FXML
    private void paper() {
        gameProcessor.takeMove('P');
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setGameProcessor(GameProcessor gameProcessor) {
        this.gameProcessor = gameProcessor;
    }
}
