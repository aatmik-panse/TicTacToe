package models;
import java.util.List;
public class Bot extends Player {

    BotDifficultyLevel difficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}