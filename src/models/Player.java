package models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);
    public Player (String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public Move makeMove(Board board) {
        //Ask the player to make a move asking the symbol and the position
        System.out.println("Enter the row number you want to play ?");
        int row = scanner.nextInt();
        System.out.println("Enter the column number you want to play ?");
        int col = scanner.nextInt();
        return new Move(new Cell(row, col), this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
}