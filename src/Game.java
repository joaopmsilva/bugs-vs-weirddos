import Bug.BugOne;
import Grid.BugGrid;
import Grid.PlayerGrid;
import Player.PlayerController;
import Props.Cpu;

public class Game {


    private PlayerController playerController;
    private BugGrid bugGrid;
    private Cpu cpu;
    private PlayerGrid playerGrid;
    private BugOne bug1;
    private final int DELAY=500;

    public void init() throws InterruptedException {

        playerGrid = new PlayerGrid(20, 20);

        bugGrid = new BugGrid(20, 20);
        cpu = new Cpu(playerGrid);
        playerController = new PlayerController(playerGrid, cpu);
        playerController.init();
        bug1 = new BugOne(bugGrid, cpu);

        while(cpu.getHealth()>0){
            Thread.sleep(DELAY);
            bug1.bugMove();
        }


    }



}
