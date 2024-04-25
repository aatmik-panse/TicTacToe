import controllers.GameController;
import exceptions.InvalidMoveException;
import models.*;
import java.util.List;
import java.util.Scanner;

import static models.PlayerType.BOT;
import static models.PlayerType.HUMAN;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        System.out.println("2 Player TicTacToe Game Started!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1 name: ");
        String player1 = scanner.nextLine();
        System.out.println("Enter Player 2 name: ");
        String player2 = scanner.nextLine();

        System.out.println("Enter "+player1+"'s symbol: ");
        char symbol1 = scanner.next().charAt(0);
        System.out.println("Enter "+player2+"'s symbol: ");
        char symbol2 = scanner.next().charAt(0);

        System.out.println("Enter "+player1+"'s type (HUMAN/BOT): ");
        String playerType1 = scanner.next();
        System.out.println("Enter "+player2+"'s type (HUMAN/BOT): ");
        String playerType2 = scanner.next();

        Player playerOne;
        Player playerTwo;

        if(playerType1.equals("HUMAN")){
            playerOne = new Player(player1, new Symbol(symbol1), HUMAN);
        }
        else{
            playerOne = new Bot(player1, new Symbol(symbol1), BOT, BotDifficultyLevel.EASY);
        }
        if(playerType2.equals("HUMAN")){
            playerTwo = new Player(player2, new Symbol(symbol2), HUMAN);
        }
        else{
            playerTwo = new Bot(player2, new Symbol(symbol2), BOT, BotDifficultyLevel.EASY);
        }


        List<Player> playerNames = List.of(
                playerOne,playerTwo
        );


        int size = 3;
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