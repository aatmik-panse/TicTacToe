package models;

import exceptions.InvalidMoveException;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private  int nextPlayerIndex ;

    public Game(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void printBoard(Game game) {
        this.board.printBoard();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        Move move = currentPlayer.makeMove(board);
        //check if the move is valid
        if(!validateMove(move)){
            throw new InvalidMoveException("Invalid Move by" + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
    }
    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }
        return true;
    }
}