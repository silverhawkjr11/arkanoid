import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private int blockType; //1- removable, 2- ballKiller, 3- border
    private List<HitListener> hitListeners;
    /**
     * this is a constructor.
     * @param rectangle represents the rectangle that is the shape of our block.
     * */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
    }
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (this.rectangle.getUpperEdge().inRangeOneLine(collisionPoint)
        || this.rectangle.getLowerEdge().inRangeOneLine(collisionPoint)) {
            currentVelocity.setDy(currentVelocity.getDy() * -1);
        }
        if (this.rectangle.getRightEdge().inRangeOneLine(collisionPoint)
        || this.rectangle.getLeftEdge().inRangeOneLine(collisionPoint)) {
            currentVelocity.setDx(currentVelocity.getDx() * -1);
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        rectangle.drawOnDrawsurface(d);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
    /**
     * this func notifies all the hitListeners of our block that a hit just happened.
     * @param hitter : the ball that hit our block.
     * */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * this func removes our block from a received game.
     * @param game : the game that we seek to remove our ball from.
     * */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
}
