import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class CountdownAnimation implements Animation {
    private double numOfSecs;
    private int countFrom;
    private SpriteCollection spriteCollection;
    private boolean stopper;
    /**
     * this is a constructor.
     * @param countFrom the number of secs.
     * @param gameScreen a sprite collection.
     * @param numOfSeconds the number of secs.
     * */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.numOfSecs = numOfSeconds;
        this.spriteCollection = gameScreen;
        this.stopper = false;
    }
    /**
     * this func does one frame of the animation.
     * @param d :the drawSurface of the frame.
     * */
    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.spriteCollection.drawAllOn(d);
        d.setColor(Color.GREEN);
        d.drawText(385, 300, Integer.toString(this.countFrom), 60);
        this.numOfSecs = this.numOfSecs - 1;
        this.countFrom = (int) this.numOfSecs;
        if (numOfSecs == 0) {
            stopper = true;
        }
    }
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    public boolean shouldStop() {
        return stopper;
    }
}