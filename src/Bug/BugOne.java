package Bug;

import Grid.BugGrid;
import Grid.CollisionDetector;
import Props.Cpu;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class BugOne extends Bug {

public BugOne(BugGrid bugGrid, Cpu cpu, CollisionDetector collisionDetector){
    super(bugGrid, cpu, collisionDetector);
    pos.setColor(Color.RED);
    damage = 1;
}




}
