package Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BugGrid extends Grid {

    private Rectangle bugField;

    public BugGrid(int cols, int rows) {

        super(cols, rows);
        bugField = new Rectangle(PADDING, PADDING, cols*CELL_SIZE+CELL_SIZE, rows*CELL_SIZE+CELL_SIZE);
        bugField.draw();
    }


}
