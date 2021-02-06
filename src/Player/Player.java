package Player;

import Grid.PlayerGrid;
import Grid.Position;
import Props.Cpu;

public class Player {

    private int speed;
    private Position position;
    private PlayerGrid playerGrid;
    private Cpu cpu;


    public Player(PlayerGrid playerGrid, Cpu cpu){

        position = new Position(playerGrid, 5, 5);
        speed = 1;
        this.playerGrid = playerGrid;
        this.cpu = cpu;
    }

    public void move(Direction direction){
        switch(direction){

            case DOWN:

                position.moveDown(cpu);
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
