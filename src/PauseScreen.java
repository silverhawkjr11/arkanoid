import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * this is a constructor.
     * @param k the keyboard sensor.
     * */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * this func does one frame of the animation.
     * @param d :the drawSurface of the frame.
     * */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    public boolean shouldStop() {
        return this.stop;
    }
}
