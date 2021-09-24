import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import java.awt.Color;
import java.util.List;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Ball implements Sprite {
    private Velocity velocity;
    /**
     * @return this func returns the center of the ball.
     * */
    public Point getCenter() {
        return center;
    }

    private Point center;
    private int radius;
    private Color color;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;
    // constructor
    /**
     * this is a constructor.
     * @param center represents the coordinates of the center point of the ball.
     * @param r represents the radius of the ball.
     * @param color represents the color of the ball.
     * @param gameEnvironment represents the game environment that the ball exists in.
     * */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * this is a constructor.
     * @param x represents the x coordinate of the center of the ball.
     * @param y represents the y coordinate of the center of the ball.
     * @param radius represents the radius of the ball.
     * @param color represents the ball's color.
     * @param gameEnvironment represents the game environment that the ball exists in.
     * */
    public Ball(int x, int y, int radius, Color color, GameEnvironment gameEnvironment) {
        Point c = new Point(x, y);
        this.center = c;
        this.radius = radius;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * this is a constructor.
     * @param point represents the balls initial center point.
     * @param radius represents the radius of the ball.
     * @param color represents the ball's color.
     * */
    public  Ball(Point point, int radius, Color color) {
        this.center = point;
        this.radius = radius;
        this.color = color;
    }
    // accessors
    /**
     * @return the x coordinate of the center point of the ball.
     * */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return the y coordinate of the center point of the ball.
     * */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return the radius of the ball.
     * */
    public int getSize() {
        return this.radius;
    }
    /**
     * @return the color of the ball.
     * */
    public Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface
    /**
     * this func draws the ball on a given drawSurface.
     * @param surface represents the drawSurface that we seek to draw the ball on.
     * */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this func sets the ball's velocity to be equal to a given velocity.
     * @param v represents the velocity value that we seek to give to the ball.
     * */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * @return this func returns the ball's velocity value.
     * */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * this func moves the ball to its destination according to the velocity of the ball
     * taking in consideration that the ball doesn't escape from the gui frame.
     * */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo info = this.gameEnvironment.getClosestCollision(trajectory);
        if (info.collisionObject() == null && info.collisionPoint() == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            if (info.collisionObject().getCollisionRectangle().getUpperEdge().inRangeOneLine(info.collisionPoint())) {
                this.center = new Point(info.collisionPoint().getX(), info.collisionPoint().getY() - radius);
            } else if (info.collisionObject().getCollisionRectangle()
                    .getLowerEdge().inRangeOneLine(info.collisionPoint())) {
                this.center = new Point(info.collisionPoint().getX(), info.collisionPoint().getY() + radius);
            } else if (info.collisionObject().getCollisionRectangle()
                    .getLeftEdge().inRangeOneLine(info.collisionPoint())) {
                this.center = new Point(info.collisionPoint().getX() - radius, info.collisionPoint().getY());
            } else if (info.collisionObject().getCollisionRectangle()
                    .getRightEdge().inRangeOneLine(info.collisionPoint())) {
                this.center = new Point(info.collisionPoint().getX() + radius, info.collisionPoint().getY());
            }
            this.velocity = info.collisionObject().hit(this, info.collisionPoint(), this.velocity);
        }
    }
    /**
     * this func receives the borders of the frame its supposed to move in and move's the ball
     * according to its velocity and taking in consideration that the ball doesnt escape the frame.
     * @param firstHeightEdge represents the upper edge of the frame.
     * @param secondHeightEdge represents the lower edge of the frame.
     * @param firstWidthEdge represents the left edge of the frame.
     * @param secondWidthEdge represents the left edge of the frame.
     * */
    public void moveOneStepWithEdges(int firstHeightEdge, int secondHeightEdge,
                                     int firstWidthEdge, int secondWidthEdge) {
        if (this.center.getX() < firstWidthEdge + this.radius) {
            this.center.setX(firstWidthEdge + this.radius);
        }
        if (this.center.getX() > secondWidthEdge - this.radius) {
            this.center.setX(secondWidthEdge - this.radius);
        }
        if (this.center.getY() < firstHeightEdge + this.radius) {
            this.center.setY(firstHeightEdge + this.radius);
        }
        if (this.center.getY() > secondHeightEdge - this.radius) {
            this.center.setY(secondHeightEdge - this.radius);
        }
        Point dest = this.getVelocity().applyToPoint(this.center);
        if (dest.getX() < firstWidthEdge + this.radius || dest.getX() > secondWidthEdge - this.radius) {
            this.velocity.setDx(-1 * this.velocity.getDx());
        }
        if (dest.getY() < firstHeightEdge + this.radius || dest.getY() > secondHeightEdge - this.radius) {
            this.velocity.setDy(-1 * this.velocity.getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    /**
     * this func sets a new received gameEnvironment to our gameEnvironment field.
     * @param ge represents our new gameEnvironment value.
     * */
    public void setGameEnvironment(GameEnvironment ge) {
        this.gameEnvironment = ge;
    }
    /**
     * this func removes our ball from a received game.
     * @param game : the game.
     * */
    void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}