import geometry.Line;
import geometry.Point;

import java.util.LinkedList;
import java.util.List;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class GameEnvironment {
    /**
     * this is a constructor.
     * @param collidables represents a list of collidables that exists within our game environment.
     * */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = collidables;
    }
    /**
     * @return our collidables list.
     * */
    public List<Collidable> getCollidables() {
        return collidables;
    }
    /**
     * this is a setter for our collidables.
     * @param newCollidables : the new value of our collidables.
     * */
    public void setCollidables(List<Collidable> newCollidables) {
        this.collidables = newCollidables;
    }
    private List<Collidable> collidables;
    // add the given collidable to the environment.
    /**
     * this is a constructor.
     * */
    public GameEnvironment() {
        this.collidables  = new LinkedList<Collidable>();
    }
    /**
     * this func adds a received collidable to our collidable collection.
     * @param c the collidable that we seek to add.
     * */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    /**
     * this func searches for an intersection with a received line to one of our collidables.
     * @param trajectory the line that we seek to find its intersection.
     * @return collision info about the collision that happened between the line and one of our collidables.
     * */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point intersectionPoint = null;
        Collidable collidable = null;
        for (Collidable c : this.collidables) {
            if (trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()) != null) {
                intersectionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
                collidable = c;
                break;
            }
        }
        CollisionInfo info = new CollisionInfo(intersectionPoint, collidable);
        return info;
    }
    /**
     * this func removes a received collidable from our collidables list.
     * @param c the received collidable.
     * */
    void removeItem(Collidable c) {
        this.collidables.remove(c);
    }
}