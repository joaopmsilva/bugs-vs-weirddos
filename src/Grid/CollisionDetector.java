package Grid;

import Bug.Bug;

public class CollisionDetector {

    private Bug[] bugs;

    public void setBugsArray(Bug[] bugs){
        this.bugs = bugs;
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

}
