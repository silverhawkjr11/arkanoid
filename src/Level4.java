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
public class Level4 implements LevelInformation {
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
    public Level4() {
        this.gameEnvironment = new GameEnvironment();
        this.spriteCollection = new SpriteCollection();
        //background
        ArrayList<Circle> circles = new ArrayList<Circle>();
        ArrayList<Line> lines = new ArrayList<Line>();
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        double x1 = 90;
        double y1 = 400;
        double x2 = 60;
        double y2 = 570;
        for (int i = 0; i < 10; i++) {
            Line rain = new Line(new Point(x1, y1), new Point(x2, y2));
            rain.setColor(Color.white);
            lines.add(rain);
            x1 += 10;
            x2 += 10;
        }
        x1 = 650;
        y1 = 450;
        x2 = 635;
        y2 = 570;
        for (int i = 0; i < 10; i++) {
            Line rain = new Line(new Point(x1, y1), new Point(x2, y2));
            rain.setColor(Color.white);
            lines.add(rain);
            x1 += 10;
            x2 += 10;
        }
        Rectangle backgroundColor = new Rectangle(new Point(30, 30), 740, 540,
                new Color(51, 153, 255));
        rectangles.add(backgroundColor);
        //left cloud
        Circle c1 = new Circle(new Point(80, 390), 20,
                new Color(204, 204, 204), true);
        Circle c2 = new Circle(new Point(110, 370), 30,
                new Color(102, 102, 102), true);
        Circle c3 = new Circle(new Point(130, 380), 25,
                new Color(204, 204, 204), true);
        Circle c4 = new Circle(new Point(150, 360), 40,
                new Color(153, 153, 153), true);
        Circle c5 = new Circle(new Point(170, 370), 30,
                new Color(153, 153, 153), true);
        circles.add(c4);
        circles.add(c5);
        circles.add(c3);
        circles.add(c2);
        circles.add(c1);
        //right cloud
        Circle c6 = new Circle(new Point(640, 440), 30,
                new Color(153, 153, 153), true);
        Circle c7 = new Circle(new Point(670, 430), 50,
                new Color(102, 102, 102), true);
        Circle c9 = new Circle(new Point(700, 450), 40,
                new Color(102, 102, 102), true);
        Circle c8 = new Circle(new Point(720, 440), 40,
                new Color(102, 102, 102), true);
        circles.add(c7);
        circles.add(c8);
        circles.add(c6);
        circles.add(c9);
        BackGround backGround1 = new BackGround(rectangles, lines, circles);
        this.spriteCollection.addSprite(backGround1);
        //borders
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
        this.blocks = new ArrayList<Block>();
        double width = 740 / 15;
        double height = 20;
        double x = 30;
        double y = 60;
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.pink, Color.CYAN};
        for (int i = 0; i < 7; i++) {
            x = 30;
            for (int j = 0; j < 15; j++) {
                Rectangle rec = new Rectangle(new Point(x, y), width, height, colors[i]);
                Block block = new Block(rec);
                this.blocks.add(block);
                this.gameEnvironment.addCollidable(block);
                this.spriteCollection.addSprite(block);
                x += width;
            }
            y += height;
        }
    }
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(Velocity.fromAngleAndSpeed(-135, 5));
        velocities.add(Velocity.fromAngleAndSpeed(-90, 5));
        velocities.add(Velocity.fromAngleAndSpeed(-45, 5));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return new String("Final Four");
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
