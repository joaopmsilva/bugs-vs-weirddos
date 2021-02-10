package Props;

import Grid.Grid;
import Grid.Position;

public class CoffeeCup {
    private Grid grid;
    private Position position;
    private boolean isPicked;
    private static int pickedCoffees;

    public CoffeeCup(Grid grid) {
        this.grid = grid;
        position = new Position(grid, "c");
    }

    public void setPicked(){
        isPicked = true;
        position.hide();
        pickedCoffees++;
        System.out.println(pickedCoffees);
    }

    public void setWasted(){
        isPicked = true;
        position.hide();
    }

    public Position getPosition(){
        return position;
    }

    public int getPickedCoffees(){
        return pickedCoffees;
    }

    public void drinkCoffees(int num) {
        pickedCoffees -= num;
    }

}
