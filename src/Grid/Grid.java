package Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Grid  {

    protected static final int PADDING = 10;
    protected static final int CELL_SIZE = 15;

    private int colNum;
    private int rowNum;

    public Grid(int cols, int rows) {

        colNum = cols;
        rowNum = rows;
    }


    public int colToX(int col) {
        return col*CELL_SIZE+PADDING;
    }

    public int rowToY(int row) {
        return row*CELL_SIZE+PADDING;
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
