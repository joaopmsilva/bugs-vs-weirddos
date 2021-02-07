import Bug.Bug;
import Bug.BugOne;
import Grid.BugGrid;
import Grid.CollisionDetector;
import Grid.PlayerGrid;
import Grid.Position;
import Player.Player;
import Player.PlayerController;
import Props.Cpu;

public class Game {


    private PlayerController playerController;
    private BugGrid bugGrid;
    private Cpu cpu;
    private PlayerGrid playerGrid;
    private final int DELAY=500;
    private CollisionDetector collisionDetector;
    private Bug[] bugs;
    private int stage = 1;


    public void init() throws InterruptedException {

        playerGrid = new PlayerGrid(20, 20);

        bugGrid = new BugGrid(20, 20);
        cpu = new Cpu(playerGrid);
        playerController = new PlayerController(playerGrid, cpu);
        playerController.init();
        collisionDetector = new CollisionDetector();

        bugs = new Bug[stage + stage * 2];
        for (int i = 0; i < bugs.length; i++) {
            bugs[i] = new BugOne(bugGrid, cpu);
        }

        int count = 0;

        while (cpu.getHealth() > 0) {
            Thread.sleep(DELAY);
            for (int i = 0; i< bugs.length; i++) {
                bugs[i].bugMove();
                if (collisionDetector.collisionDetector(playerController.getPlayer().getPlayerPosition(), bugs[i].getBugPosition())) {
                    bugs[i].setIsDead();
                    count++;
                    System.out.println(count);
                }
            }

        }
    }

}
