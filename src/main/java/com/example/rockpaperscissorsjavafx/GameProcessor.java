package com.example.rockpaperscissorsjavafx;

import com.example.controllers.GameController;
import com.example.controllers.GameEndController;
import com.example.controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

public class GameProcessor {
    MainController mainController;
    private int playerScore;
    private int computerScore;
    private int maxValue;
    private char actualPlayerMove;
    private char actualComputerMove;

    public GameProcessor(int maxValue) {
        this.maxValue = maxValue;
    }
    public void takeMove(char move, int playerScore, int computerScore) {
        this.playerScore = playerScore;
        this.computerScore = computerScore;
        this.actualPlayerMove = move;

        gameProcessor();
    }
    private void gameProcessor() {
        randomMove(actualComputerMove);
        roundProcess();
        maxRoundCheck();
    }
    private char randomMove(char actualComputerMove) {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0: setActualComputerMove('R');
            break;
            case 1: setActualComputerMove('P');
            break;
            case 2: setActualComputerMove('S');
            break;
            }
        return actualComputerMove;
    }
    private void roundProcess() {
        if(actualPlayerMove != actualComputerMove) {
            if(actualPlayerMove == 'R') {
                switch (actualComputerMove) {
                    case 'P': setComputerScore(getComputerScore()+1);
                    break;
                    case 'S': setPlayerScore(getPlayerScore()+1);
                }
            }
            if(actualPlayerMove == 'P') {
                switch (actualComputerMove) {
                    case 'S': setComputerScore(getComputerScore()+1);
                        break;
                    case 'R': setPlayerScore(getPlayerScore()+1);
                }
            }
            if(actualPlayerMove == 'S') {
                switch (actualComputerMove) {
                    case 'R': setComputerScore(getComputerScore()+1);
                        break;
                    case 'P': setPlayerScore(getPlayerScore()+1);
                }
            }
        }
    }
    public String getStringValueOfPlayerMove() {
        return moveToString(actualPlayerMove);
    }
    public String getStringValueOfComputerMove() {
        return moveToString(actualComputerMove);
    }
    private String moveToString(char actualMove) {
        String name = null;
        if(actualMove == 'R') {
            name = "Kamień";
        }
        if(actualMove == 'P') {
            name = "Papier";
        }
        if(actualMove == 'S') {
            name = "Nożyce";
        }
        return name;
    }
    private void maxRoundCheck() {
        if (playerScore >= maxValue || computerScore >= maxValue) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/GameEndScreen.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            GameEndController gameEndController = loader.getController();
            mainController.setMenuScreen(pane);
            gameEndController.setMainController(mainController);
            gameEndController.gameEndValueSetter(playerScore,computerScore);
        }
    }
    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public void setActualComputerMove(char actualComputerMove) {
        this.actualComputerMove = actualComputerMove;
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
