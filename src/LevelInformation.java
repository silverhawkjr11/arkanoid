import java.util.List;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public interface LevelInformation {
    /**
     * @return the number of balls in the level.
     * */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**
     * @return a list of the velocities of the balls within the level.
     * */
    List<Velocity> initialBallVelocities();
    /**
     * @return the speed of the paddle;
     * */
    int paddleSpeed();
    /**
     * @return the width of the paddle;
     * */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.
    /**
     * @return the name of the level.
     * */
    String levelName();
    // Returns a sprite with the background of the level
    /**
     * @return the background of the level.
     * */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    /**
     * @return a list of removable blocks within the level.
     * */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    /**
     * @return the number of blocks to remove.
     * */
    int numberOfBlocksToRemove();
    /**
     * @return the sprites of our level.
     * */
    SpriteCollection getSprites();
    /**
     * @return the collidables of our game.
     * */
    GameEnvironment getGameEnviroment();
    /**
     * @return the paddle of our game.
     * */
    Paddle getPaddle();
}
