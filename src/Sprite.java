import biuoop.DrawSurface;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the drawSurface that we seek to draw our sprite on.
     * */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     * */
    void timePassed();
    /**
     * adds our Sprite to a received game.
     * @param g the game that we seek to add our sprite to.
     * */
    void addToGame(GameLevel g);
}