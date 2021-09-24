import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private Animation animation;
    private boolean running;
    private String keyPressed;
    /**
     * this is a constructor.
     * @param key the animation stopping key.
     * @param an the animation that we seek to run.
     * @param sensor our keyboardSensor.
     * */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation an) {
        this.running = true;
        this.animation = an;
        this.keyboardSensor = sensor;
        this.keyPressed = key;
    }
    /**
     * this func does one frame of the animation.
     * @param d :the drawSurface of the frame.
     * */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.shouldStop()) {
            animation.doOneFrame(d);
        }
    }
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    @Override
    public boolean shouldStop() {
        return this.keyboardSensor.isPressed(this.keyPressed);
    }
}
