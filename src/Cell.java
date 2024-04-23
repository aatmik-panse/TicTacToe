public class Cell {
    private int row;
    private int col;
    Player player;
    CellState.cellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.player = null;
        this.cellState = CellState.cellState.EMPTY;
    }


}
