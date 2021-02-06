package Props;

import Grid.PlayerGrid;
import Grid.Position;

public class Cpu {
    private int health;
    private PlayerGrid playerGrid;
    private Position position;
    private static final int DIMENSION = 3;


    public Cpu(PlayerGrid playerGrid){

        position = new Position(playerGrid, (playerGrid.getColNum()/2)-(DIMENSION/2), (playerGrid.getRowNum()/2)-(DIMENSION/2), DIMENSION, this);
        this.playerGrid = playerGrid;

        health = 100;
    }

    public boolean isAtCpuBorder(Position position){
        boolean isAtCpuBorder = false;
        if (position.getRow()==this.position.getRow()-1 && (position.getCol()==this.position.getCol()||position.getCol()==this.position.getCol()+1 || position.getCol()==this.position.getCol()+2)){
            isAtCpuBorder=true;
        }
        return isAtCpuBorder;
    }





}
