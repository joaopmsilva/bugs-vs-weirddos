package Grid;

import Props.Cpu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static Grid.Grid.CELL_SIZE;
import static Grid.Grid.PADDING;

public class Position {

    private int col;
    private int row;
    private Grid grid;

    private Rectangle placeholder;

    public Position(Grid grid){
        this.grid = grid;
        int randomizer = (int)(Math.random()*4);
        switch(randomizer){
           case 0:
               col=0;
               row = (int) (Math.random()* grid.getRowNum());
               break;
           case 1:
               col= grid.getColNum();
               row = (int) (Math.random()* grid.getRowNum());
               break;
           case 2:
               col = (int) (Math.random()* grid.getColNum());
               row=0;
               break;
           case 3:
               col = (int) (Math.random()* grid.getColNum());
               row= grid.getRowNum();
               break;
            }

        placeholder = new Rectangle(col*CELL_SIZE+PADDING,row*CELL_SIZE+PADDING, CELL_SIZE, CELL_SIZE);
        show();
    }

    public Position(Grid grid, int col, int row) {

        this.grid = grid;
        this.col = col;
        this.row = row;

        placeholder = new Rectangle(col*CELL_SIZE+PADDING,row*CELL_SIZE+PADDING, CELL_SIZE, CELL_SIZE);
        show();

    }

    public Position (Grid grid, int col, int row, int dimension){
        this.grid = grid;
        this.col = col;
        this.row= row;

        placeholder = new Rectangle(col*CELL_SIZE+PADDING,row*CELL_SIZE+PADDING, CELL_SIZE*dimension, CELL_SIZE*dimension);
        show();

    }

    public void moveDown(Cpu cpu){


        if(row + 1 > grid.getRowNum() - 1 || cpu.isAtCpuTopBorder(this)){
            return;
        }
        placeholder.translate(0, CELL_SIZE);
        row++;
    }

    public void moveUp(Cpu cpu){

        if(row - 1 < 1 || cpu.isAtCpuBottomBorder(this)){
         return;
        }
        placeholder.translate(0, -CELL_SIZE);
        row--;
    }

    public void moveRight(Cpu cpu){

        if(col + 1 > grid.getColNum() - 1 || cpu.isAtCpuLeftBorder(this)){
            return;
        }
        placeholder.translate(CELL_SIZE, 0);
        col++;
    }

    public void moveLeft(Cpu cpu){

        if(col - 1 < 1 || cpu.isAtCpuRightBorder(this)){
            return;
        }
        placeholder.translate(-CELL_SIZE, 0);
        col--;
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

    public boolean equals(Position position){
        return (this.getRow()==position.getRow() && this.getCol()== position.getCol());

    }
}
