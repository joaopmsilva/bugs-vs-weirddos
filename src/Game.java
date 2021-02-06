import Grid.BugGrid;
import Player.PlayerController;

public class Game {


    private PlayerController playerController;
    private BugGrid bugGrid;
    public void init(){

        bugGrid = new BugGrid(20, 20);
        playerController = new PlayerController(20, 20);
        playerController.init();

    }



}
