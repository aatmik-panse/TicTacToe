import controllers.GameController;
import exceptions.InvalidMoveException;
import models.*;
import java.util.List;
import java.util.Scanner;

import static models.PlayerType.BOT;
import static models.PlayerType.HUMAN;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        System.out.println("Game Started!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the board");
        int size = 3;
        List<Player> playerNames = List.of(
                new Player("Player 1",new Symbol('*'),HUMAN ),
                new Player("Player 2",new Symbol('o'),HUMAN )
        );
        GameController gameController = new GameController();
        Game game = gameController.startGame(size, playerNames);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            //print the board
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if (!gameController.checkGameStatus(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            gameController.printBoard(game);
            System.out.println("Game DRAW");
        }
        else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}