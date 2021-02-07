package Grid;

import Bug.Bug;
import Player.Player;

public class CollisionDetector {

    public boolean collisionDetector(Position position, Position position2) {
        if(position.equals(position2)){
            return true;
        }
        return false;
    }

}
