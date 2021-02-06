package Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerGrid extends Grid {

    private Rectangle playerField;

    public PlayerGrid(int cols, int rows) {

        super(cols, rows);
        playerField = new Rectangle(PADDING+CELL_SIZE, PADDING+CELL_SIZE, cols*CELL_SIZE-CELL_SIZE, rows*CELL_SIZE-CELL_SIZE);
        playerField.draw();

    }




}
