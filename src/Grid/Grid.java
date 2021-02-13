package Grid;

public abstract class Grid  {

    protected static final int PADDING = 20;
    protected static final int CELL_SIZE = 25;

    private int colNum;
    private int rowNum;

    public Grid(int cols, int rows) {
        colNum = cols;
        rowNum = rows;
    }

    public int getColNum() {
        return colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getCellSize(){
        return CELL_SIZE;
    }

}
