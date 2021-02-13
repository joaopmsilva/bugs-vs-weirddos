package Game;

import Bug.Bug;
import Bug.BugOne;
import Grid.BugGrid;
import Grid.CollisionDetector;
import Grid.PlayerGrid;
import Player.PlayerController;
import Props.CoffeeCup;
import Props.Cpu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private PlayerController playerController;
    private BugGrid bugGrid;
    private Cpu cpu;
    private PlayerGrid playerGrid;
    private CollisionDetector collisionDetector;
    private Bug[] bugs;
    private CoffeeCup[] coffeeCups;
    private Text bugsKillScore;
    private Text coffeeScore;
    private Text cpuScore;
    private int coffeesToSpend;
    private Text coffeeToSpend;
    private Text stageNumber;
    private static Color color = new Color(199, 193, 169);
    private final int DELAY = 800;
    public int stage = 1;
    private final static int COL_NUM = 26;
    private final static int ROW_NUM = 26;
    private final static double CPU_OFFSET = 7.4;
    public boolean isStarted;

    public void playerInit() {

        bugGrid = new BugGrid(COL_NUM, ROW_NUM);
        playerGrid = new PlayerGrid(COL_NUM, ROW_NUM);
        cpu = new Cpu(playerGrid);
        collisionDetector = new CollisionDetector();

        setTexts();

        playerController = new PlayerController(playerGrid, cpu, collisionDetector, this);
        playerController.init();

        while(!isStarted){
            Thread.yield();
        }
        setStage(stage);
    }


    public void setTexts() {
        bugsKillScore = new Text( 875, 206, "0");
        bugsKillScore.grow(8,8);
        bugsKillScore.setColor(color);
        bugsKillScore.draw();

        coffeeScore = new Text(875, 235, "0");
        coffeeScore.grow(8,8);
        coffeeScore.setColor(color);
        coffeeScore.draw();

        coffeeToSpend = new Text(847, 350, "X");
        coffeeToSpend.grow(8, 8);
        coffeeToSpend.setColor(Color.RED);
        coffeeToSpend.draw();

        stageNumber = new Text(865, 440, String.valueOf(stage));
        stageNumber.grow(8, 8);
        stageNumber.setColor(color);
        stageNumber.draw();

        cpuScore = new Text(cpu.getCpuHealthXPos()+CPU_OFFSET, cpu.getCpuHealthYPos(), "100");
        cpuScore.grow(6*3, 8);
        cpuScore.draw();

    }

    public void setStage(int stage) {

        coffeesToSpend = stage - 2;

        if(coffeeCups != null){
            for (CoffeeCup coffeeCup : coffeeCups) {
                coffeeCup.setWasted();
            }
        }

        if (stage % 2 == 0 && stage != 2) {
            coffeeCups = new CoffeeCup[stage / 2];
            for (int i = 0; i < coffeeCups.length; i++) {
                coffeeCups[i] = new CoffeeCup(playerGrid);
            }
        }
        collisionDetector.setCoffeeCups(coffeeCups);


        bugs = new Bug[stage + stage * 2];
        for (int i = 0; i < bugs.length; i++) {
            bugs[i] = new BugOne(bugGrid, cpu, collisionDetector);
        }
        collisionDetector.setBugsArray(bugs, stage);

        startStage();

    }

    public void startStage() {

        while (bugs[0].getStageDeadBugs() < bugs.length && cpu.getHealth() > 0) {

            try{
                Thread.sleep(DELAY);
            }catch(InterruptedException | IllegalArgumentException e) {
                e.printStackTrace();
            }

            stageUpdate();

            for (int i = 0; i < bugs.length; i++) {
                if(cpu.getHealth() > 0) {
                    bugs[i].bugMove();
                    bugKillScoreUpdate();
                    cpuScoreUpdate();
                    if(stage > 3) {
                        coffeeScoreUpdate();
                        coffeeToSpendUpdate();
                    }
                    if (collisionDetector.collisionDetector(bugs[i].getBugPosition(), playerController.getPlayer().getPlayerPosition())) {
                        bugs[i].setIsDead();
                    }
                }
            }
        }

        if(cpu.getHealth() < 1) {
            Picture picture = new Picture(0, 0, "gameover.jpg");
            picture.draw();
            isStarted = false;
            while (!isStarted){
                Thread.yield();
            }
            picture.delete();
            restartGame();
            return;

        }
        setStage(++stage);

    }

    public void restartGame(){
        cpu.setHealth();
        coffeeCups[0].setPickedCoffees();
        for(Bug bug: bugs){
            bug.setIsDead();
        }
        bugs[0].resetBugs();
        bugsKillScore.delete();
        cpuScore.delete();
        coffeeToSpend.delete();
        stageNumber.delete();
        coffeeScore.delete();
        stage = 1;
        setTexts();
        setStage(1);
    }

    public void bugKillScoreUpdate(){
        bugsKillScore.delete();
        bugsKillScore = new Text(875, 206, String.valueOf(bugs[0].getDeadBugs()));
        bugsKillScore.grow(8*String.valueOf(bugs[0].getDeadBugs()).length(),8);
        bugsKillScore.setColor(color);
        bugsKillScore.draw();
    }

    public void cpuScoreUpdate(){
        cpuScore.delete();
        cpuScore = new Text(cpu.getCpuHealthXPos()+CPU_OFFSET, cpu.getCpuHealthYPos(), String.valueOf(cpu.getHealth()));
        cpuScore.grow(6*String.valueOf(cpu.getHealth()).length(),8);
        cpuScore.draw();
    }

    public void coffeeScoreUpdate(){
        coffeeScore.setText(String.valueOf(coffeeCups[0].getPickedCoffees()));
    }

    public void coffeeToSpendUpdate(){
        coffeeToSpend.delete();
        coffeeToSpend = new Text(849, 350, String.valueOf(coffeesToSpend));
        coffeeToSpend.setColor(color);
        coffeeToSpend.grow(8*String.valueOf(coffeesToSpend).length(), 8);
        coffeeToSpend.draw();
    }

    public void stageUpdate(){
        stageNumber.setText(String.valueOf(stage));
    }

}
