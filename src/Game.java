import Bug.Bug;
import Bug.BugOne;
import Grid.BugGrid;
import Grid.CollisionDetector;
import Grid.PlayerGrid;
import Grid.ScoreGrid;
import Player.PlayerController;
import Props.CoffeeCup;
import Props.Cpu;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {

    private PlayerController playerController;
    private BugGrid bugGrid;
    private Cpu cpu;
    private PlayerGrid playerGrid;
    private ScoreGrid scoreGrid;
    private final int DELAY=800;
    private final int STAGE_DELAY=1000;
    private CollisionDetector collisionDetector;
    private Bug[] bugs;
    private int stage = 1;
    private CoffeeCup[] coffeeCups;
    private Text bugsKillScore;
    private Text coffeeScore;
    private Text cpuScore;


    public void init(int cols, int rows) throws InterruptedException {
        scoreGrid = new ScoreGrid(cols, rows);
        bugGrid = new BugGrid(cols, rows);
        playerGrid = new PlayerGrid(cols, rows);
        cpu = new Cpu(playerGrid);
        collisionDetector = new CollisionDetector();
        playerController = new PlayerController(playerGrid, cpu, collisionDetector);
        playerController.init();
        bugsKillScore = new Text( scoreGrid.getKillPosX(), scoreGrid.getKillPosY(), "Score : 0");
        bugsKillScore.draw();
        coffeeScore = new Text(scoreGrid.getCoffeePosX(), scoreGrid.getCoffeePosY(), "Coffees : 0");
        coffeeScore.draw();
        cpuScore = new Text(cpu.getCpuHealthXPos(), cpu.getCpuHealthYPos(), "100");
        cpuScore.draw();
        setStage(stage);

    }

    public void setStage(int stage) throws InterruptedException {

        if(stage >= 2){
            for(CoffeeCup cup: coffeeCups){
                cup.setWasted();
            }
        }

        coffeeCups = new CoffeeCup[stage-1];
        for (int j = 0; j < coffeeCups.length; j++) {
            coffeeCups[j] = new CoffeeCup(playerGrid);
        }
        collisionDetector.setCoffeeCups(coffeeCups);


        bugs = new Bug[stage + stage * 2];
        for (int i = 0; i < bugs.length; i++) {
            bugs[i] = new BugOne(bugGrid, cpu, collisionDetector);
        }
        collisionDetector.setBugsArray(bugs);


        startStage();

    }

    public void startStage() throws InterruptedException {

        Thread.sleep(STAGE_DELAY * stage);

        while (bugs[0].getStageDeadBugs() < bugs.length && cpu.getHealth() > 0) {
            Thread.sleep(DELAY);
            for (int i = 0; i < bugs.length; i++) {
                if(cpu.getHealth() > 0) {
                    bugs[i].bugMove();
                    bugsKillScore.delete();
                    bugsKillScore = new Text( scoreGrid.getKillPosX(), scoreGrid.getKillPosY(), "Score : " + bugs[0].getDeadBugs());
                    bugsKillScore.draw();
                    cpuScore.delete();
                    cpuScore = new Text(cpu.getCpuHealthXPos(), cpu.getCpuHealthYPos(), String.valueOf(cpu.getHealth()));
                    cpuScore.draw();
                    if(stage>1) {
                        coffeeScore.delete();
                        coffeeScore = new Text(scoreGrid.getCoffeePosX(), scoreGrid.getCoffeePosY(), "Coffees: " + coffeeCups[0].getPickedCoffees());
                        coffeeScore.draw();
                    }
                    if (collisionDetector.collisionDetector(bugs[i].getBugPosition(), playerController.getPlayer().getPlayerPosition())) {
                        bugs[i].setIsDead();
                    }
                }
            }
        }

        if(cpu.getHealth() < 1) {
            System.out.println("Game Over at stage " + stage + " with " + bugs[0].getDeadBugs() +
                    " bugs killed and drank way too much coffee: " + coffeeCups[0].getPickedCoffees());
            return;
        }
        setStage(++stage);

    }


}
