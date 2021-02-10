package Grid;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreGrid extends Grid{

    private Rectangle scoreGrid;
    private Text killScore;
    private Text coffeeScore;
    private int killPosX;
    private int killPosY;
    private int coffeePosX;
    private int coffeePosY;

    public ScoreGrid(int cols, int rows){
        super(cols/3, rows);

        scoreGrid = new Rectangle(PADDING+cols*CELL_SIZE+CELL_SIZE, PADDING, cols/3*CELL_SIZE+CELL_SIZE, rows*CELL_SIZE+CELL_SIZE);
        scoreGrid.draw();

        killPosX = (PADDING+cols*CELL_SIZE+CELL_SIZE+CELL_SIZE) + CELL_SIZE;
        killPosY = PADDING+CELL_SIZE;

        coffeePosX = PADDING+cols*CELL_SIZE+CELL_SIZE+CELL_SIZE + CELL_SIZE;
        coffeePosY = PADDING + CELL_SIZE + 2*CELL_SIZE;

    }

    public int getKillPosX(){
        return killPosX;
    }

    public int getKillPosY(){
        return killPosY;
    }

    public int getCoffeePosX(){
        return coffeePosX;
    }

    public int getCoffeePosY(){
        return coffeePosY;
    }
}
