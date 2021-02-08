import Bug.Bug;
import Bug.BugOne;
import Grid.BugGrid;
import Grid.CollisionDetector;
import Grid.PlayerGrid;
import Player.PlayerController;
import Props.Cpu;

public class Game {

    private PlayerController playerController;
    private BugGrid bugGrid;
    private Cpu cpu;
    private PlayerGrid playerGrid;
    private final int DELAY=500;
    private final int STAGE_DELAY=1000;
    private CollisionDetector collisionDetector;
    private Bug[] bugs;
    private int stage = 1;

    public void init(int cols, int rows) throws InterruptedException {
        bugGrid = new BugGrid(cols, rows);
        playerGrid = new PlayerGrid(cols, rows);
        cpu = new Cpu(playerGrid);
        collisionDetector = new CollisionDetector();
        playerController = new PlayerController(playerGrid, cpu, collisionDetector);
        playerController.init();

        setStage(stage);

    }

    public void setStage(int stage) throws InterruptedException {

        bugs = new Bug[stage + stage * 2];
        for (int i = 0; i < bugs.length; i++) {
            bugs[i] = new BugOne(bugGrid, cpu);
        }
        collisionDetector.setBugsArray(bugs);
        startStage();

    }

    public void startStage() throws InterruptedException {

        Thread.sleep(STAGE_DELAY * stage);

        while (bugs[0].getDeadBugs() < bugs.length && cpu.getHealth() > 0) {
            Thread.sleep(DELAY);
            for (int i = 0; i < bugs.length; i++) {
                if(cpu.getHealth() > 0) {
                    bugs[i].bugMove();
                    if (collisionDetector.collisionDetector(bugs[i].getBugPosition(), playerController.getPlayer().getPlayerPosition())) {
                        bugs[i].setIsDead();
                    }
                }
            }
        }

        if(cpu.getHealth() < 1) {
            System.out.println("Game Over at stage " + stage + " with X bugs killed!");
            return;
        }
        setStage(++stage);

    }

}
