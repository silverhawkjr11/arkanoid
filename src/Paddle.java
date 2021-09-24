import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Paddle implements Sprite, Collidable {
//    public void setKeyboard(KeyboardSensor keyboard) {
//        this.keyboard = keyboard;
//    }

    private KeyboardSensor keyboard;
    private Rectangle rectangle;
    /**
     * @return the speed of the paddle.
     * */
    public int getSpead() {
        return spead;
    }

    private int spead;
    private GameEnvironment environment;
    /**
     * this is a constructor.
     * @param keyboardSensor the keyboard sensor that controls our paddle.
     * @param rectangle the rectangle that represents the shape of our paddle.
     * */
    public Paddle(KeyboardSensor keyboardSensor, Rectangle rectangle) {
        this.keyboard = keyboardSensor;
        this.rectangle = rectangle;
    }
    /**
     * this is a constructor.
     * @param keyboardSensor the keyboard sensor that controls our paddle.
     * @param rectangle the rectangle that represents the shape of our paddle.
     * @param sp : the speed of the paddle.
     * */
    public Paddle(KeyboardSensor keyboardSensor, Rectangle rectangle, int sp) {
        this.keyboard = keyboardSensor;
        this.rectangle = rectangle;
        this.spead = sp;
    }
    /**
     * this func moves our paddle 5 unites to the left.
     * */
    public void moveLeft() {

        if (this.rectangle.getUpperLeft().getX() >= 35) {
            this.rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() - this.spead,
                    rectangle.getUpperLeft().getY()),
                    rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());
        }
    }
    /**
     * this func moves our paddle 5 unites to the right.
     * */
    public void moveRight() {
        if (this.rectangle.getRightEdge().start().getX() <= 765) {
            this.rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() + this.spead,
                    rectangle.getUpperLeft().getY()),
                    rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());
        }
    }

    // Sprite
    /**
     * this func notifies our paddle that time has passed.
     * */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();;
        }
    }
    /**
     * this func draws our paddle on a given drawSurface.
     * @param d the drawSurface that we seek to draw our paddle on.
     * */
    public void drawOn(DrawSurface d) {
        d.setColor(rectangle.getColor());
        d.fillRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    // Collidable
    /**
     * @return the rectangle that represents the shape of our paddle.
     * */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * this func is called whenever a ball hits our paddle.
     * @param currentVelocity the current velocity of the ball.
     * @param collisionPoint the point which a ball hit our paddle.
     * @param hitter : the ball that hit the block.
     * @return the new velocity of the ball after it hit our paddle.
     * */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x = this.rectangle.getWidth() / 5;
        Line first = new Line(this.rectangle.getUpperLeft(),
                new Point(this.rectangle.getUpperLeft().getX() + x,
                        this.rectangle.getUpperLeft().getY()));
        Line second = new Line(first.end(), new Point(first.end().getX() + x, first.end().getY()));
        Line third = new Line(second.end(), new Point(second.end().getX() + x, second.end().getY()));
        Line forth = new Line(third.end(), new Point(third.end().getX() + x, third.end().getY()));
        Line fifth = new Line(forth.end(), new Point(forth.end().getX() + x, forth.end().getY()));
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        if (first.inRangeOneLine(collisionPoint)) {
            currentVelocity = Velocity.fromAngleAndSpeed(210, speed);
        } else if (second.inRangeOneLine(collisionPoint)) {
            currentVelocity = Velocity.fromAngleAndSpeed(240, speed);
        } else if (third.inRangeOneLine(collisionPoint)) {
            currentVelocity.setDy(currentVelocity.getDy() * -1);
        } else if (forth.inRangeOneLine(collisionPoint)) {
            currentVelocity = Velocity.fromAngleAndSpeed(300, speed);
        } else if (fifth.inRangeOneLine(collisionPoint)) {
            currentVelocity = Velocity.fromAngleAndSpeed(330, speed);
        } else {
            if (this.rectangle.getLeftEdge().inRangeOneLine(collisionPoint)
                    || this.rectangle.getRightEdge().inRangeOneLine(collisionPoint)) {
                currentVelocity.setDx(currentVelocity.getDx() * -1);
            } else {
                currentVelocity.setDy(currentVelocity.getDy() * -1);
            }
        }
        return currentVelocity;
    }

    // Add this paddle to the game.
    /**
     * this func adds our paddle to a received game.
     * @param g the game that we wish to add our paddle to.
     * */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * @return the first section of the upper edge of the rectangle.
     * */
    public Line firstThird() {
        Point start = this.rectangle.getUpperLeft();
        Point end = new Point(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 3,
                this.rectangle.getUpperLeft().getY());
        return new Line(start, end);
    }
    /**
     * @return the second section of the upper edge of the rectangle.
     * */
    public Line secondThird() {
        Point start = this.firstThird().end();
        Point end = new Point(start.getX() + this.rectangle.getWidth() / 3,
                this.rectangle.getUpperLeft().getY());
        return new Line(start, end);
    }
    /**
     * @return the third section of the upper edge of the rectangle.
     * */
    public Line theThirdThird() {
        Point start = this.secondThird().end();
        Point end = new Point(start.getX() + this.rectangle.getWidth() / 3,
                this.rectangle.getUpperLeft().getY());
        return new Line(start, end);
    }
}