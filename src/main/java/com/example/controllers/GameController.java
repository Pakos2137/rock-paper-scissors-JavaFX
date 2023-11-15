package com.example.controllers;

import com.example.rockpaperscissorsjavafx.GameProcessor;
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
    private Label computerMoveLabel;
    @FXML
    private Label playerMoveLabel;

    private int actualPlayerScore = 0;
    private int actualComputerScore = 0;
    public void valuesSetter() {
        playerScoreLabel.setText("0");
        computerScoreLabel.setText("0");
    }
    @FXML
    private void backToMenu() {
        scoreReset();
        mainController.loadMenuScreen();
    }
    @FXML
    private void scoreReset() {
        gameProcessor.setPlayerScore(0);
        gameProcessor.setComputerScore(0);
        valuesSetter();
        computerMoveLabel.setText("");
        playerMoveLabel.setText("");
    }
    @FXML
    private void scissors() {
        choosePicker('S');
    }
    @FXML
    private void rock() {
        choosePicker('R');
    }
    @FXML
    private void paper() {
        choosePicker('P');
    }
    private void setValuesToLabels() {
        actualPlayerScore = Integer.valueOf(playerScoreLabel.getText());
        actualComputerScore = Integer.valueOf(computerScoreLabel.getText());
    }
    private void setNewValues() {
        playerScoreLabel.setText(String.valueOf(gameProcessor.getPlayerScore()));
        computerScoreLabel.setText(String.valueOf(gameProcessor.getComputerScore()));
        playerMoveLabel.setText(gameProcessor.getStringValueOfPlayerMove());
        computerMoveLabel.setText(gameProcessor.getStringValueOfComputerMove());
    }
    private void choosePicker(char moveType) {
        setValuesToLabels();
        gameProcessor.takeMove(moveType,actualPlayerScore,actualComputerScore);
        setNewValues();
    }
    public void nameSetter(String name) {
        playerNameLabel.setText(name + ":");
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setGameProcessor(GameProcessor gameProcessor) {
        this.gameProcessor = gameProcessor;
    }
}
