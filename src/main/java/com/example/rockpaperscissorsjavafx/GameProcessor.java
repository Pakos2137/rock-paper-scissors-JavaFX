package com.example.rockpaperscissorsjavafx;

import javafx.fxml.FXML;

public class GameProcessor {
    GameController gameController;
    private int playerScore= 0;
    private int computerScore = 0;
    private int maxValue;

    public GameProcessor(int maxValue) {
        this.maxValue = maxValue;
    }
    public void takeMove(char move) {
        System.out.println(move);
        //setPlayerScore(getPlayerScore() + 1);
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
