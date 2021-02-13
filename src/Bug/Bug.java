package Bug;

import Grid.BugGrid;
import Grid.CollisionDetector;
import Grid.Position;
import Props.Cpu;

public abstract class Bug {

    private boolean isDead;
    protected int damage;
    private boolean isAtCpu;
    private Cpu cpu;
    protected Position pos;
    private static int deadBugs;
    private static int stageDeadBugs;
    private CollisionDetector collisionDetector;

    private int destCol;
    private int destRow;


    public Bug(BugGrid bugGrid, Cpu cpu, CollisionDetector collisionDetector){
        this.cpu=cpu;
        this.collisionDetector = collisionDetector;
        stageDeadBugs = 0;

        destCol = (int)(Math.ceil(bugGrid.getColNum()/2));
        destRow = (int)(Math.ceil(bugGrid.getRowNum()/2));

        pos = new Position(bugGrid);
    }

    public int getDeadBugs(){
        return deadBugs;
    }

    public int getStageDeadBugs() {
        return stageDeadBugs;
    }

    public void resetBugs(){
        deadBugs = 0;
        stageDeadBugs = 0;
    }

    public void setIsDead(){
        isDead = true;
        pos.hide();
        deadBugs++;
        stageDeadBugs++;
    }

    public Position getBugPosition(){
        return pos;
    }

    public void bugMove() {
        if(isDead) return;

        collisionDetector.bugIsOnCoffeeCup(pos);
        isAtCpu();
        if (isAtCpu) {
            cpu.loseHealth(damage);
            return;
        }
        if(pos.getCol()==destCol){
            if (pos.getRow() < destRow) {
                pos.moveDown(cpu);
            } else {
                pos.moveUp(cpu);
            }
            return;

        }
        if (pos.getRow()==destRow){
            if (pos.getCol() < destCol) {
                pos.moveRight(cpu);
            } else {
                pos.moveLeft(cpu);
            }
            return;
        }
        int chooseDirection = (int) (Math.random() * 2);
        switch (chooseDirection) {
            case 0:
                if (pos.getCol() < destCol) {
                    pos.moveRight(cpu);
                } else if (pos.getCol() > destCol) {
                    pos.moveLeft(cpu);
                }
                break;
            case 1:
                if (pos.getRow() < destRow) {
                    pos.moveDown(cpu);
                } else {
                    pos.moveUp(cpu);
                }
                break;
        }
    }

    public void isAtCpu(){
        if(cpu.isAtCpuRightBorder(pos)){
            isAtCpu=true;
        } else if (cpu.isAtCpuLeftBorder(pos)){
            isAtCpu=true;
        } else if (cpu.isAtCpuBottomBorder(pos)){
            isAtCpu=true;
        } else if (cpu.isAtCpuTopBorder(pos)){
            isAtCpu=true;
        }

    }


}
