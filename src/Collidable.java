import geometry.Point;
import geometry.Rectangle;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public interface Collidable {
    /**
     * @return Return the "collision shape" of the object.
     * */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @return The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     * @param collisionPoint represents the collision point that our collidable collided with.
     * @param currentVelocity represents the current velocity of the ball that collided with our collidable.
     * @param hitter the ball that hit the block.
     * */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
    /**
     * this func adds our collidable to a given game.
     * @param g represents the game that we want to add our collidable to.
     * */
    void addToGame(GameLevel g);
}