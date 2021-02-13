package Props;

import Grid.PlayerGrid;
import Grid.Position;

public class Cpu {
    private int health;
    private Position position;
    private static final int DIMENSION = 3;
    private final int cpuHealthXPos;
    private final int cpuHealthYPos;


    public Cpu(PlayerGrid playerGrid){

        position = new Position(playerGrid, (playerGrid.getColNum()/2)-(DIMENSION/2), (playerGrid.getRowNum()/2)-(DIMENSION/2), DIMENSION);

        health = 100;

        cpuHealthXPos = ((playerGrid.getColNum()/2)-(DIMENSION/2))*playerGrid.getCellSize()+(playerGrid.getCellSize())+13;
        cpuHealthYPos = ((playerGrid.getRowNum()/2)-(DIMENSION/2))*playerGrid.getCellSize()+(playerGrid.getCellSize())+14;

    }

    public int getCpuHealthXPos(){
        return cpuHealthXPos;
    }

    public int getCpuHealthYPos(){
        return cpuHealthYPos;
    }

    public boolean isAtCpuTopBorder(Position position){
        boolean isAtCpuBorder = false;
        if (position.getRow()==this.position.getRow()-1 && (position.getCol()==this.position.getCol()||position.getCol()==this.position.getCol()+1 || position.getCol()==this.position.getCol()+2)){
            isAtCpuBorder=true;
        }
        return isAtCpuBorder;
    }

    public boolean isAtCpuBottomBorder(Position position){
        boolean isAtCpuBorder = false;
        if (position.getRow()==this.position.getRow()+3 && (position.getCol()==this.position.getCol()||position.getCol()==this.position.getCol()+1 || position.getCol()==this.position.getCol()+2)){
            isAtCpuBorder=true;
        }
        return isAtCpuBorder;
    }

    public boolean isAtCpuLeftBorder(Position position){
        boolean isAtCpuBorder = false;
        if (position.getCol()==this.position.getCol()-1 && (position.getRow()==this.position.getRow()||position.getRow()==this.position.getRow()+1 || position.getRow()==this.position.getRow()+2)){
            isAtCpuBorder=true;
        }
        return isAtCpuBorder;
    }

    public boolean isAtCpuRightBorder(Position position){
        boolean isAtCpuBorder = false;
        if (position.getCol()==this.position.getCol()+3 && (position.getRow()==this.position.getRow()||position.getRow()==this.position.getRow()+1 || position.getRow()==this.position.getRow()+2)){
            isAtCpuBorder=true;
        }
        return isAtCpuBorder;
    }

    public void loseHealth(int damage){
        health -= damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(){
        health = 100;
    }
}
