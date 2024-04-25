package controllers;
import java.util.*;

import exceptions.InvalidMoveException;
import models.Game;
import models.GameState;
import models.Player;

public class GameController {
    public Game startGame(int size, List<Player> players) {
        // TODO: Implement this method
        // Validate the symbol of each player
        // If the 2 symbols are the same, throw an exception (InvalidPlayerException) custom exception

        // If the size is less than 3, throw an exception (InvalidBoardSizeException) custom exception
        return new Game(size, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkGameStatus(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public int getNextPlayerIndex(Game game) {
        return game.getNextPlayerMoveIndex();
    }

    public void printBoard(Game game) {
        game.getBoard().printBoard();
    }

}
