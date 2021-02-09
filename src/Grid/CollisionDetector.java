package Grid;

import Bug.Bug;
import Props.CoffeeCup;

public class CollisionDetector {

    private Bug[] bugs;
    private CoffeeCup[] coffeeCups;

    public void setBugsArray(Bug[] bugs){
        this.bugs = bugs;
    }

    public void setCoffeeCups(CoffeeCup[] coffeeCups) {
        this.coffeeCups = coffeeCups;
    }

    public boolean collisionDetector(Position position, Position position2) {
        return position.equals(position2);
    }

    public void isOnTopOfBug(Position position){

        for(Bug currentBug : bugs){
            if(currentBug.getBugPosition().equals(position)){
                currentBug.setIsDead();
            }
        }

    }

    public void isOnCoffeeCup(Position position){

        for(CoffeeCup cup : coffeeCups) {
            if (cup.getPosition().equals(position)) {
                cup.setPicked();
            }
        }

    }

}
