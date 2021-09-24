import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class WinScreen implements Animation {
    private KeyboardSensor keyboardSensor;
    private boolean won;
    private Counter score;
    /**
     * this is a constructor.
     * @param finalScore : the players final score.
     * @param ks : the keyboard sensor.
     * */
    public WinScreen(KeyboardSensor ks, Counter finalScore) {
        this.keyboardSensor = ks;
        this.won = false;
        this.score = finalScore;
    }
    /**
     * this func does one frame of the animation.
     * @param d :the drawSurface of the frame.
     * */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(50, 300, "YOU WIN!\nYOUR SCORE IS:" + this.score.getValue(), 40);
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.won = true;
        }
    }
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    @Override
    public boolean shouldStop() {
        return this.won;
    }
}
