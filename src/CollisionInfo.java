import geometry.Point;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class CollisionInfo {
    /**
     * @return our collision point.
     * */
    public Point getCollisionPoint() {
        return collisionPoint;
    }

    private Point collisionPoint;
    /**
     * @return our collisionObject.
     * */
    public Collidable getCollisionObject() {
        return collisionObject;
    }

    private Collidable collisionObject;
    // the point at which the collision occurs.
    /**
     * this is a constructor.
     * @param p represents the collision point.
     * @param c represents the collision rectangle.
     * */
    public CollisionInfo(Point p, Collidable c) {
        this.collisionPoint = p;
        this.collisionObject = c;
    }
    /**
     * @return our collision pont.
     * */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collidable object involved in the collision.
     * */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}