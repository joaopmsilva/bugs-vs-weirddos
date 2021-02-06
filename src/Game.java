import Grid.BugGrid;
import Grid.PlayerGrid;
import Player.PlayerController;
import Props.Cpu;

public class Game {


    private PlayerController playerController;
    private BugGrid bugGrid;
    private Cpu cpu;
    private PlayerGrid playerGrid;

    public void init(){

        playerGrid = new PlayerGrid(20, 20);

        bugGrid = new BugGrid(20, 20);
        playerController = new PlayerController(playerGrid);
        playerController.init();

        cpu = new Cpu(playerGrid);

    }



}
