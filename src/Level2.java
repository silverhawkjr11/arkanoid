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
public class Level2 implements LevelInformation {
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
    public Level2() {
        this.gameEnvironment = new GameEnvironment();
        this.spriteCollection = new SpriteCollection();
        //this.gameEnvironment.addCollidable(this.paddle);
        //this.spriteCollection.addSprite(this.paddle);
        this.numOfBalls = 10;
        this.ballVelocities = new LinkedList<Velocity>();
        this.ballVelocities.add(Velocity.fromAngleAndSpeed(-90, 5));
        Rectangle border1Rect = new Rectangle(new Point(0, 0), 30, 570, Color.GRAY); // left
        Rectangle border2Rect = new Rectangle(new Point(0, 570), 800, 30, Color.GRAY); // down
        Rectangle border3Rect = new Rectangle(new Point(30, 0), 770, 30, Color.GRAY); // up
        Rectangle border4Rect = new Rectangle(new Point(770, 30), 30, 700, Color.GRAY); // right
        Block border1 = new Block(border1Rect);
        Block border3 = new Block(border3Rect);
        Block border4 = new Block(border4Rect);
        this.gameEnvironment.addCollidable(border1);
        this.gameEnvironment.addCollidable(border3);
        this.gameEnvironment.addCollidable(border4);
        this.spriteCollection.addSprite(border1);
        this.spriteCollection.addSprite(border3);
        this.spriteCollection.addSprite(border4);
        //blocks
        Color blockColor = Color.red;
        this.blocks = new LinkedList<Block>();
        Point upLeft = new Point(30, 200);
        for (int i = 0; i < 15; i++) {
            if (i == 0 || i == 1) {
                blockColor = Color.RED;
            }
            if (i == 2 || i == 3) {
                blockColor = Color.ORANGE;
            }
            if (i == 4 || i == 5) {
                blockColor = Color.YELLOW;
            }
            if (i >= 6 && i <= 8) {
                blockColor = Color.GREEN;
            }
            if (i == 9 || i == 10) {
                blockColor = Color.BLUE;
            }
            if (i == 11 || i == 12) {
                blockColor = Color.PINK;
            }
            if (i == 13 || i == 14) {
                blockColor = Color.CYAN;
            }
            Rectangle rectangle = new Rectangle(upLeft, 740 / 15, 23, blockColor);
            Block block = new Block(rectangle);
            this.blocks.add(block);
            this.gameEnvironment.addCollidable(block);
            this.spriteCollection.addSprite(block);
            Point temp = upLeft;
            upLeft = new Point(temp.getX() + 740 / 15, temp.getY());
        }
        //background
        Circle c1 = new Circle(new Point(200, 100), 60, Color.YELLOW, true);
        Circle c2 = new Circle(new Point(200, 100), 80, Color.ORANGE, true);
        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(c2);
        circles.add(c1);
        ArrayList<Line> lines = new ArrayList<Line>();
        Point beamSource = new Point(200, 100);
        double y = 200;
        double x = 30;
        for (int i = 0; i < 100; i++) {
            Line beam = new Line(beamSource, new Point(x, y));
            beam.setColor(Color.ORANGE);
            lines.add(beam);
            x += 740 / 100;

        }
        BackGround backGround1 = new BackGround(null, lines, circles);
        this.spriteCollection.addSprite(backGround1);
        //velocities
        this.ballVelocities = new ArrayList<Velocity>();
        Velocity v = Velocity.fromAngleAndSpeed(160 + 32, 5);
        for (int i = 1; i <= 10; i++) {
            this.ballVelocities.add(v);
            v = Velocity.fromAngleAndSpeed(((160 + 32) + i * (160 / 10)), 5);
        }
    }
    @Override
    public int numberOfBalls() {
        return 10;
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
        return 500;
    }

    @Override
    public String levelName() {
        return new String("Wide Easy");
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
        return this.blocks.size();
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
