import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class LostScreen implements Animation {
    private KeyboardSensor keyboardSensor;
    private boolean lost;
    private Counter score;
    /**
     * this is a constructor.
     * @param finalScore : the final score of the game.
     * @param ks : the keyboard sensor of the game.
     * */
    public LostScreen(KeyboardSensor ks, Counter finalScore) {
        this.keyboardSensor = ks;
        this.lost = false;
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
        d.drawText(50, 300, "YOU LOST!\nYOUR SCORE IS:" + this.score.getValue(), 40);
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.lost = true;
        }
    }
    /**
     * @return this func returns true if the animation should stop and false otherwise.
     * */
    @Override
    public boolean shouldStop() {
        return this.lost;
    }
}
