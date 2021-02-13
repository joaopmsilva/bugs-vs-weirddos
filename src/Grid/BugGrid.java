package Grid;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BugGrid extends Grid {

    private Picture picture;

    public BugGrid(int cols, int rows) {
        super(cols, rows);
        picture = new Picture (10, 10, "background.jpg");
        picture.draw();
    }

}
