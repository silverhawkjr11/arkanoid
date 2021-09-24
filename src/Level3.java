import geometry.Circle;
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
public class Level3 implements LevelInformation {
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
    public Level3() {
        this.gameEnvironment = new GameEnvironment();
        this.spriteCollection = new SpriteCollection();
        //background
        Rectangle backgroundColor = new Rectangle(new Point(30, 30), 740, 570,
                new Color(41, 153, 0));
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        rectangles.add(backgroundColor);
        Rectangle building = new Rectangle(new Point(50, 450), 90, 150,
                new Color(102, 102, 102));
        rectangles.add(building);
        Rectangle tinyBuilding = new Rectangle(new Point(80, 410), 30, 40, Color.GRAY);
        Rectangle hugeStick = new Rectangle(new Point(90, 410 - 160), 10, 160,
                new Color(204, 204, 204));
        rectangles.add(hugeStick);
        rectangles.add(tinyBuilding);
        int x = 55;
        int width = 12;
        int height = 24;
        int y = 455;
        for (int i = 0; i < 5; i++) {
            x = 55;
            for (int j = 0; j < 5; j++) {
                Rectangle window = new Rectangle(new Point(x, y), width, height, Color.white);
                rectangles.add(window);
                x += 5 + 12;
            }
            y += 5 + 24;
        }
        Point centers = new Point(95, 410 - 160 - 10);
        Circle wightCircle = new Circle(centers, 3, Color.white, true);
        Circle redCircle = new Circle(centers, 7, Color.RED, true);
        Circle orangeCircle = new Circle(centers, 10, Color.ORANGE, true);
        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(orangeCircle);
        circles.add(redCircle);
        circles.add(wightCircle);
        BackGround backGround1 = new BackGround(rectangles, null, circles);
        //borders
        this.spriteCollection.addSprite(backGround1);
        //this.gameEnvironment.addCollidable(this.paddle);
       // this.spriteCollection.addSprite(this.paddle);
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
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        int flag = 1;
        int b = 0;
        x = 170;
        y = 100;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10 - b; j++) {
                Rectangle rec = new Rectangle(new Point(x, y), 60, 20, colors[i]);
                Block block = new Block(rec);
                this.blocks.add(block);
                this.gameEnvironment.addCollidable(block);
                this.spriteCollection.addSprite(block);
                x += 60;
            }
            y += 20;
            b += 1;
            x = 170 + b * 60;
        }
    }
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        this.ballVelocities = new ArrayList<Velocity>();
        this.ballVelocities.add(Velocity.fromAngleAndSpeed(-135, 5));
        this.ballVelocities.add(Velocity.fromAngleAndSpeed(-45, 5));
        return this.ballVelocities;
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
        return new String("Green 3");
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
