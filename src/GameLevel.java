import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
import java.util.List;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    /**
     * @return this func returns our score value.
     * */
    public Counter getScore() {
        return score;
    }

    private Counter score = new Counter();
    private boolean running;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner runner;
    private LevelInformation information;
    /**
     * this is a setter for finalLevel.
     * @param fL the new finalLevel val.
     * */
    public void setFinalLevel(boolean fL) {
        this.finalLevel = fL;
    }

    private boolean finalLevel;
    /**
     * @return our lives val.
     * */
    public Counter getLives() {
        return lives;
    }
    /**
     * setter for lives.
     * @param ls our new lives val.
     * */
    public void setLives(Counter ls) {
        this.lives = ls;
    }

    private Counter lives;

    /**
     * @return our remainingBlocks value.
     * */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }
    /**
     * this is a setter for remainingBlocks.
     * @param remaining : the new remainingBlocks value.
     * */
    public void setRemainingBlocks(Counter remaining) {
        this.remainingBlocks = remaining;
    }

    private Counter remainingBlocks = new Counter();
    /**
     * @return our environment value.
     * */
    public GameEnvironment getEnvironment() {
        return environment;
    }
    /**
     * @return our remainingBalls value.
     * */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }
    /**
     * this is a setter for remainingBalls.
     * @param remaining : the new remainingBalls value.
     * */
    public void setRemainingBalls(Counter remaining) {
        this.remainingBalls = remaining;
    }

    private Counter remainingBalls = new Counter();
    private GameEnvironment environment;
    private GUI gui;
    private Paddle paddle;
    /**
     * this is a constructor to our Game class.
     * @param levelInformation information about this level.
     * @param gui1 the graphical user interface of this level.
     * @param ar the animation runner.
     * @param keyboardSensor1 our keyboard sensor.
     * */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor1, AnimationRunner ar, GUI gui1) {
        this.gui = gui1;
        this.keyboardSensor = keyboardSensor1;
        this.runner = ar;
        this.information = levelInformation;
        this.lives = new Counter();
        this.finalLevel = false;
    }
    /**
     * this func adds a received collidable to our collidables collection.
     * @param c the collidable we wish to add.
     * */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }
    /**
     * this func adds a received sprite to our sprites collection.
     * @param s the sprite we wish to add.
     * */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
    /**
     * this func initializes our game adds all the elements in it.
     * */
    public void initialize() {
        this.running = true;
        this.sprites = this.information.getSprites();
        this.environment = this.information.getGameEnviroment();
        this.remainingBalls = new Counter();
        this.score = new Counter();
        this.remainingBlocks = new Counter();
        this.remainingBlocks.increase(this.information.numberOfBlocksToRemove());
        this.keyboardSensor = gui.getKeyboardSensor();
        if (this.information.levelName().equals("Direct Hit")) {
            this.paddle = new Paddle(this.keyboardSensor, new Rectangle(new Point(800 / 2 - 45, 550),
                    information.paddleWidth(), 20, Color.ORANGE), information.paddleSpeed());
        }
        if (this.information.levelName().equals("Wide Easy")) {
            this.paddle = new Paddle(gui.getKeyboardSensor(),
                    new Rectangle(new Point(150, 550), information.paddleWidth(),
                            20, Color.ORANGE), information.paddleSpeed());
        }
        if (this.information.levelName().equals("Green 3")) {
            this.paddle = new Paddle(gui.getKeyboardSensor(),
                    new Rectangle(new Point(800 / 2 - 45, 550), information.paddleWidth(),
                            20, Color.ORANGE), information.paddleSpeed());
        }
        if (this.information.levelName().equals("Final Four")) {
            this.paddle = new Paddle(gui.getKeyboardSensor(),
                    new Rectangle(new Point(350, 550), information.paddleWidth(),
                            20, Color.ORANGE), information.paddleSpeed());
        }
        this.paddle.addToGame(this);
        List<Block> blocks = information.blocks();
        for (Block b: blocks) {
            b.addHitListener(new BlockRemover(this, this.remainingBlocks));
            b.addHitListener(new ScoreTrackingListener(score));
        }
        Rectangle rct = new Rectangle(new Point(0, 570), 770, 30, Color.GRAY);
        Block ballKiller = new Block(rct);
        ballKiller.addHitListener(new BallRemover(this, this.remainingBalls));
        ballKiller.addToGame(this);
        this.runner = new AnimationRunner(this.gui);
        this.createBallsOnTopOfPaddle();
        /*Color color = Color.RED;
        int flag = 1;
        Rectangle r1 = new Rectangle(new Point(780, 0), 20, 600, Color.BLACK);
        Block border1 = new Block(r1);
        border1.addToGame(this);
        Rectangle r2 = new Rectangle(new Point(0, 30), 800, 20, Color.BLACK);
        Block border2 = new Block(r2);
        border2.addToGame(this);
        Rectangle r3 = new Rectangle(new Point(0, 0), 20, 600, Color.BLACK);
        Block border3 = new Block(r3);
        border3.addToGame(this);
        Rectangle r4 = new Rectangle(new Point(0, 580), 800, 20, Color.BLACK);
        Block border4 = new Block(r4);
        border4.addHitListener(new BallRemover(this, remainingBalls));
        border4.addToGame(this);
        Rectangle paddleRect = new Rectangle(new Point(350, 560), 100, 20, Color.YELLOW);
        paddle = new Paddle(gui.getKeyboardSensor(), paddleRect);
        paddle.addToGame(this);
        this.createBallsOnTopOfPaddle();
        for (int i = 160; i < 260; i += 20) {
            for (int j = 160; j < 750; j += 50) {
                if (flag == 1) {
                    j += (i - 160) * 5 / 2;
                    flag = 0;
                }
                if (i == 160) {
                    color = Color.GRAY;
                }
                if (i == 180) {
                    color = Color.RED;
                }
                if (i == 200) {
                    color = Color.YELLOW;
                }
                if (i == 220) {
                    color = Color.BLUE;
                }
                if (i == 240) {
                    color = Color.PINK;
                }
                if (i == 260) {
                    color = Color.GREEN;
                }
                Rectangle rectangle = new Rectangle(new Point(j, i), 50, 20, color);
                Block block = new Block(rectangle);
                remainingBlocks.increase(1);
                BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
                ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
                block.addHitListener(blockRemover);
                block.addHitListener(scoreTrackingListener);
                block.addToGame(this);
            }
            flag = 1;
        }*/
    }

    /**
     * Run the game -- start the animation loop.
     * */
    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(3, 3, this.sprites));
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        int flag = 0;
        while (!this.shouldStop()) { // shouldStop() is in charge of stopping condition.
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            this.doOneFrame(d); // doOneFrame(DrawSurface) is in charge of the logic.

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        sleeper.sleepFor(100);
    }
    /**
     * this func creates balls on the top of our paddle.
     * */
    private void createBallsOnTopOfPaddle() {
        if (this.information.levelName().equals("Direct Hit")) {
            Point c = new Point(400, 400);
            Ball ball = new Ball(c, 4, Color.WHITE, this.environment);
            ball.setVelocity(this.information.initialBallVelocities().get(0));
            ball.addToGame(this);
            this.remainingBalls.increase(1);
        }
        if (this.information.levelName().equals("Wide Easy")) {
            Ball ball = new Ball(new Point(200, 500), 4, Color.BLACK, this.environment);
            for (Velocity v: this.information.initialBallVelocities()) {
                ball.setVelocity(v);
                ball.addToGame(this);
                this.remainingBalls.increase(1);
                double x = ball.getCenter().getX() + 40;
                ball = new Ball(new Point(x, 500), 4, Color.BLACK, this.getEnvironment());
            }
        }
        if (this.information.levelName().equals("Green 3")) {
            Ball ball = new Ball(new Point(200, 500), 4, Color.BLACK, this.environment);
            for (Velocity v: this.information.initialBallVelocities()) {
                ball.setVelocity(v);
                ball.addToGame(this);
                this.remainingBalls.increase(1);
                double x = ball.getCenter().getX() + 400;
                ball = new Ball(new Point(x, 500), 4, Color.WHITE, this.environment);
            }
        }
        if (this.information.levelName().equals("Final Four")) {
            Ball b1 = new Ball(new Point(350, 500), 4, Color.WHITE, this.environment);
            Ball b2 = new Ball(new Point(400, 450), 4, Color.WHITE, this.environment);
            Ball b3 = new Ball(new Point(450, 500), 4, Color.WHITE, this.environment);
            int i = 0;
            for (Velocity v: this.information.initialBallVelocities()) {
                if (i == 0) {
                    b1.setVelocity(v);
                    b1.addToGame(this);
                }
                if (i == 1) {
                    b2.setVelocity(v);
                    b2.addToGame(this);
                }
                if (i == 2) {
                    b3.setVelocity(v);
                    b3.addToGame(this);
                }
                this.remainingBalls.increase(1);
                i += 1;
            }
        }
        /*Point cf1 = paddle.firstThird().middle();
        Point cf2 = paddle.secondThird().middle();
        Point cf3 = paddle.TheThirdThird().middle();
        int r = 5;
        Point c1 = new Point(cf1.getX(), cf1.getY() - r);
        Point c2 = new Point(cf2.getX(), cf2.getY() - r);
        Point c3 = new Point(cf3.getX(), cf3.getY() - r);
        Ball b1 = new Ball(c1, 5, Color.BLACK, environment);
        Ball b2 = new Ball(c2, 5, Color.BLACK, environment);
        Ball b3 = new Ball(c3, 5, Color.BLACK, environment);
        b1.setVelocity(Velocity.fromAngleAndSpeed(225, 4));
        b2.setVelocity(Velocity.fromAngleAndSpeed(270, 4));
        b3.setVelocity(Velocity.fromAngleAndSpeed(315, 4));
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        remainingBalls.increase(3);*/
    }

    /**
     * this func removes a received collidable from our game environment.
     * @param c : the collidable which we seek to remove.
     * */
    void removeCollidable(Collidable c) {
        this.environment.removeItem(c);
    }
    /**
     * this func removes a received sprite from our spriteCollection.
     * @param s : the sprite which we seek to remove.
     * */
    void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * this func does one frame of the animation.
     * @param d :the drawSurface of the frame.
     * */
    @Override
    public void doOneFrame(DrawSurface d) {
        KeyPressStoppableAnimation pause = new KeyPressStoppableAnimation(this.keyboardSensor, "p",
                new PauseScreen(this.keyboardSensor));
        KeyPressStoppableAnimation win = new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new WinScreen(this.keyboardSensor, this.score));
        KeyPressStoppableAnimation lost = new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new LostScreen(this.keyboardSensor, this.score));
        if (remainingBalls.getValue() == 0) {
            if (this.lives.getValue() == 0) {
                this.running = false;
                this.runner.run(lost);
                this.gui.close();
            } else {
                this.createBallsOnTopOfPaddle();
                this.lives.decrease(1);
                this.runner.run(new CountdownAnimation(3, 3, this.sprites));
            }
        }
        if (remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            if (this.finalLevel) {
                this.runner.run(win);
                gui.close();
            }
            this.running = false;
        }
//        d.setColor(Color.blue);
//        d.fillRectangle(0, 0, this.gui.getDrawSurface().getWidth(), this.gui.getDrawSurface().getHeight());
        this.sprites.drawAllOn(d);
        d.setColor(Color.GRAY);
        d.fillRectangle(0, 0, 800, 30);
        d.setColor(Color.BLACK);
        d.drawText((int) (d.getWidth() / 2.55), d.getHeight() - (int) (d.getHeight() * 0.96),
                "your score: " + score.getValue(), 25);
        d.drawText((int) (d.getWidth() / 1.55), d.getHeight() - (int) (d.getHeight() * 0.96),
                "Level Name: " + this.information.levelName(), 25);
        d.drawText((int) (d.getWidth() / 9), d.getHeight() - (int) (d.getHeight() * 0.96),
                "Lives: " + this.lives.getValue(), 25);
        this.sprites.notifyAllTimePassed();
        if (this.keyboardSensor.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboardSensor));
        }
    }
    /**
     * this func increaces our score from the value of a received score.
     * @param s the received score.
     * */
    public void increaceScore(Counter s) {
        this.score.increase(s.getValue());
    }
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}