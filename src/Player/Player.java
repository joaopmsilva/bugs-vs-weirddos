package Player;

import Grid.PlayerGrid;
import Grid.Position;

public class Player {

    private int speed;
    private Position position;
    private PlayerGrid playerGrid;

    public Player(int col, int row){

        playerGrid = new PlayerGrid(col, row);
        position = new Position(playerGrid, 5, 5);
        speed = 1;
    }

    public void move(Direction direction){
        switch(direction){

            case DOWN:

                position.moveDown();
                break;

            case UP:

                position.moveUp();
                break;

            case RIGHT:

                position.moveRight();
                break;

            case LEFT:

                position.moveLeft();
                break;
        }


    }


}
