package Bug;

import Grid.BugGrid;
import Grid.CollisionDetector;
import Props.Cpu;

public class BugOne extends Bug {

    public BugOne(BugGrid bugGrid, Cpu cpu, CollisionDetector collisionDetector){
        super(bugGrid, cpu, collisionDetector);
        damage = 1;
    }

}
