package Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static Grid.Grid.CELL_SIZE;

public class Position {

    private int col;
    private int row;
    private Grid grid;

    private Rectangle placeholder;

    public Position(Grid grid){
        this.grid = grid;
        col = (int) Math.random()* grid.getColNum();
        row = (int) Math.random()* grid.getRowNum();

        placeholder = new Rectangle(col,row, CELL_SIZE, CELL_SIZE);
    }

    public Position(Grid grid, int col, int row) {
        this.grid = grid;
        this.col = col;
        this.row = row;

        placeholder = new Rectangle(col,row, CELL_SIZE, CELL_SIZE);

    }

    private Position (Grid grid, int col, int row, int dimension){
        this.grid = grid;
        this.col = col;
        this.row= row;

        placeholder = new Rectangle(col,row, CELL_SIZE*dimension, CELL_SIZE*dimension);

    }


    public void show() {
        placeholder.fill();
    }

    public void hide() {
        placeholder.delete();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setColor(Color color) {
        placeholder.setColor(color);
    }

    public Color getColor() {
        return placeholder.getColor();
    }

}
