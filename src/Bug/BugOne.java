package Bug;

import Grid.BugGrid;
import Props.Cpu;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class BugOne extends Bug {

public BugOne(BugGrid bugGrid, Cpu cpu){
    super(bugGrid, cpu);
    pos.setColor(Color.RED);
    damage = 1;
}




}
