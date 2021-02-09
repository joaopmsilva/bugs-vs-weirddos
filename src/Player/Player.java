package Player;

import Grid.CollisionDetector;
import Grid.PlayerGrid;
import Grid.Position;
import Props.Cpu;

public class Player {

    private int speed;
    private Position position;
    private PlayerGrid playerGrid;
    private Cpu cpu;
    private CollisionDetector collisionDetector;


    public Player(PlayerGrid playerGrid, Cpu cpu, CollisionDetector collisionDetector){
        position = new Position(playerGrid, 5, 5);
        speed = 1;
        this.playerGrid = playerGrid;
        this.cpu = cpu;
        this.collisionDetector = collisionDetector;
    }

    public Position getPlayerPosition(){
        return position;
    }

    public void move(Direction direction){
        if(cpu.getHealth() > 0) {

            switch (direction) {
                case DOWN:
                    position.moveDown(cpu);
                    break;
                case UP:
                    position.moveUp(cpu);
                    break;
                case RIGHT:
                    position.moveRight(cpu);
                    break;
                case LEFT:
                    position.moveLeft(cpu);
                    break;
            }
            collisionDetector.isOnTopOfBug(position);
            collisionDetector.isOnCoffeeCup(position);

        }

    }




}
