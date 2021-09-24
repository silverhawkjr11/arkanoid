import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    /**
     * this is a constructor.
     * @param gui1 : a graphical user interface.
     * */
    public AnimationRunner(GUI gui1) {
        this.gui = gui1;
        this.framesPerSecond = 30;
        this.sleeper = new Sleeper();
    }
    /**
     * this func runs the animation.
     * @param animation : the animation that we seek to run.
     * */
    public void run(Animation animation) {
        int millisecondsPerFrame = 300;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
