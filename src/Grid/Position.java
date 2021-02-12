package Grid;

import Props.CoffeeCup;
import Props.Cpu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static Grid.Grid.CELL_SIZE;
import static Grid.Grid.PADDING;

public class Position {

    private int col;
    private int row;
    private Grid grid;
    private Picture picture;

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

        picture = new Picture (col*CELL_SIZE+PADDING,row*CELL_SIZE+PADDING, "bugfinal.png");
        picture.draw();

    }

    public Position(Grid grid, String c) {
        this.grid = grid;
        row = (int) (Math.random()*grid.getRowNum());
        col = (int) (Math.random()*grid.getColNum());

        if ((grid.getColNum()/2-1 <= col && col <= grid.getColNum()/2+1) && (grid.getRowNum()/2-1 <= row && row <= grid.getRowNum()/2+1) ) {
            row -= 5;
        }

        if(col == 0 || row == 0){
            row++;
            col++;
        }

        picture = new Picture (col*CELL_SIZE+PADDING, row*CELL_SIZE+PADDING, "coffee_redone.png");
        picture.draw();

    }

    public Position(Grid grid, int col, int row) {

        this.grid = grid;
        this.col = col;
        this.row = row;

        picture = new Picture(col*CELL_SIZE+PADDING,row*CELL_SIZE+PADDING, "uni2.png");
        picture.draw();

    }

    public Position (Grid grid, int col, int row, int dimension){
        this.grid = grid;
        this.col = col;
        this.row= row;

        picture = new Picture(col*CELL_SIZE+PADDING,row*CELL_SIZE+PADDING, "recolcpu.jpg");
        picture.draw();

    }

    public void moveDown(Cpu cpu){


        if(row + 1 > grid.getRowNum() - 1 || cpu.isAtCpuTopBorder(this)){
            return;
        }
        row++;
        picture.translate(0, CELL_SIZE);
    }

    public void moveUp(Cpu cpu){

        if(row - 1 < 1 || cpu.isAtCpuBottomBorder(this)){
         return;
        }
        row--;
        picture.translate(0, -CELL_SIZE);
    }

    public void moveRight(Cpu cpu){

        if(col + 1 > grid.getColNum() - 1 || cpu.isAtCpuLeftBorder(this)){
            return;
        }
        col++;
        picture.translate(CELL_SIZE, 0);
    }

    public void moveLeft(Cpu cpu){

        if(col - 1 < 1 || cpu.isAtCpuRightBorder(this)){
            return;
        }
        col--;
        picture.translate(-CELL_SIZE, 0);
    }


    public void show() {
        placeholder.fill();
    }

    public void hide() {
        picture.delete();
        col = -1;
        row = -1;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean equals(Position position){
        return (this.getRow()==position.getRow() && this.getCol()== position.getCol());

    }
}
