package Grid;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreGrid extends Grid{

    private Rectangle scoreGrid;
    private Text killScore;
    private Text coffeeScore;

    private int coffeePosX;
    private int coffeePosY;


    public ScoreGrid(int cols, int rows){
        super(cols/3, rows);



        coffeePosX = PADDING+cols*CELL_SIZE+CELL_SIZE+CELL_SIZE + CELL_SIZE;
        coffeePosY = PADDING + CELL_SIZE + 2*CELL_SIZE;

    }



    public int getCoffeePosX(){
        return coffeePosX;
    }

    public int getCoffeePosY(){
        return coffeePosY;
    }
}
