import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class GameFlow {
    private GUI gui;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    /**
     * this is a constructor.
     * @param gui1 a graphical user interface.
     * */
    public GameFlow(GUI gui1) {
        this.gui = gui1;
        this.animationRunner = new AnimationRunner(this.gui);
        this.keyboardSensor = this.gui.getKeyboardSensor();
    }
    /**
     * this finc runs the levels in a given list of levels.
     * @param levels the list of levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter();
        Counter lives = new Counter();
        lives.increase(7);
        int c = 1;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner, this.gui);
            System.out.println(levelInfo.levelName());
            level.initialize();
            level.increaceScore(score);
            level.setLives(lives);

            if (levels.indexOf(levelInfo) == levels.size() - 1) {
                level.setFinalLevel(true);
            }
            while (!level.shouldStop()) {
                level.run();
                System.out.println("runnin");
            }

            if (level.getRemainingBalls().getValue() == 0) {
                break;
            }
            score = level.getScore();
            lives = level.getLives();
        }
    }
}
