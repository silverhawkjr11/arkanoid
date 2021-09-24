import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Ass6Game {
    /**
     * this is the main function that creates the GameLevel.
     * @param args -an array of strings that represents the user input.
     * */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        GameFlow flow = new GameFlow(gui);
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        if (args.length == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
            System.out.println("in");
        } else {
            for (String s: args) {
                if (s.equals("1")) {
                    levels.add(new Level1());
                }
                if (s.equals("2")) {
                    levels.add(new Level2());
                }
                if (s.equals("3")) {
                    levels.add(new Level3());
                }
                if (s.equals("4")) {
                    levels.add(new Level4());
                }
            }
        }
        flow.runLevels(levels);
    }
}
