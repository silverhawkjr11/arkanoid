import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Level1 implements LevelInformation {
    private Paddle paddle;
    private int numOfBalls;
    private List<Velocity> ballVelocities;
    private BackGround backGround;
    private GameEnvironment gameEnvironment;
    private SpriteCollection spriteCollection;
    private List<Block> blocks;
    /**
     * this is a constructor.
     * */
    public Level1() {
        this.gameEnvironment = new GameEnvironment();
        this.spriteCollection = new SpriteCollection();
        //this.gameEnvironment.addCollidable(this.paddle);
        ///background
        Rectangle blockRect = new Rectangle(new Point(380, 150), 40, 40, Color.RED);
        Line leftStreak = new Line(new Point(blockRect.getLeftEdge().middle().getX() - 100,
                blockRect.getLeftEdge().middle().getY()), blockRect.getLeftEdge().middle());
        leftStreak.setColor(Color.RED);
        Line upperStreak = new Line(blockRect.getUpperEdge().middle(),
                new Point(blockRect.getUpperEdge().middle().getX(), blockRect.getUpperEdge().middle().getY() - 100));
        upperStreak.setColor(Color.RED);
        Line rightStreak = new Line(blockRect.getRightEdge().middle(),
                new Point(blockRect.getRightEdge().middle().getX() + 100, blockRect.getRightEdge().middle().getY()));
        rightStreak.setColor(Color.RED);
        Line lowerStreak = new Line(blockRect.getLowerEdge().middle(),
                new Point(blockRect.getLowerEdge().middle().getX(), blockRect.getLowerEdge().middle().getY() + 100));
        lowerStreak.setColor(Color.RED);
        Point centerBlock = new Point(blockRect.getUpperLeft().getX() + 20, blockRect.getUpperLeft().getY() + 20);
        Circle c1 = new Circle(centerBlock, 40, Color.red, false);
        Circle c2 = new Circle(centerBlock, 60, Color.red, false);
        Circle c3 = new Circle(centerBlock, 80, Color.red, false);
        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(c1);
        circles.add(c2);
        circles.add(c3);
        ArrayList<Line> lines = new ArrayList<Line>();
        lines.add(leftStreak);
        lines.add(upperStreak);
        lines.add(lowerStreak);
        lines.add(rightStreak);
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        Rectangle backgroundColor = new Rectangle(new Point(30, 30), 840, 540, Color.BLACK);
        rectangles.add(backgroundColor);
        BackGround backGround1 = new BackGround(rectangles, lines, circles);
        this.backGround = backGround1;
        this.spriteCollection.addSprite(backGround);
        this.numOfBalls = 1;
        this.ballVelocities = new LinkedList<Velocity>();
        this.ballVelocities.add(Velocity.fromAngleAndSpeed(-90, 5));
        Rectangle border1Rect = new Rectangle(new Point(0, 0), 30, 570, Color.GRAY); // left
        Rectangle border2Rect = new Rectangle(new Point(0, 570), 800, 30, Color.GRAY); // down
        Rectangle border3Rect = new Rectangle(new Point(30, 0), 770, 30, Color.GRAY); // up
        Rectangle border4Rect = new Rectangle(new Point(770, 30), 30, 740, Color.GRAY); // left
        Block border1 = new Block(border1Rect);
        Block border3 = new Block(border3Rect);
        Block border4 = new Block(border4Rect);
        this.gameEnvironment.addCollidable(border1);
        this.gameEnvironment.addCollidable(border3);
        this.gameEnvironment.addCollidable(border4);
        Block block = new Block(blockRect);
        this.blocks = new LinkedList<Block>();
        this.blocks.add(block);
        this.gameEnvironment.addCollidable(block);
        this.spriteCollection.addSprite(block);
    }


    @Override
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.ballVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return new String("Direct Hit");
    }

    @Override
    public Sprite getBackground() {
        return this.backGround;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public SpriteCollection getSprites() {
        return this.spriteCollection;
    }

    @Override
    public GameEnvironment getGameEnviroment() {
        return this.gameEnvironment;
    }

    @Override
    public Paddle getPaddle() {
        return this.paddle;
    }
}
