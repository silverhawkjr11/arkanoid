import biuoop.DrawSurface;
import geometry.Circle;
import geometry.Line;
import geometry.Rectangle;

import java.util.ArrayList;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class BackGround implements Sprite {
    private ArrayList<Rectangle> rectangles;
    private ArrayList<Line> lines;
    private ArrayList<Circle> circles;
    /**
     * this is a constructor.
     * @param c : a list of circles.
     * @param lines : a list of lines.
     * @param rectangles : a list of rectangles.
     * */
    public BackGround(ArrayList<Rectangle> rectangles, ArrayList<Line> lines, ArrayList<Circle> c) {
        this.circles = c;
        this.rectangles = rectangles;
        this.lines = lines;
    }
    @Override
    public void drawOn(DrawSurface d) {
        if (this.rectangles != null) {
            for (Rectangle rect : this.rectangles) {
                d.setColor(rect.getColor());
                rect.drawOnDrawsurface(d);
            }
        }
        if (this.lines != null) {
            for (Line l : lines) {
                d.setColor(l.getColor());
                d.drawLine((int) l.start().getX(), (int) l.start().getY(), (int) l.end().getX(), (int) l.end().getY());
            }
        }
        if (this.circles != null) {
            for (Circle c : circles) {
                d.setColor(c.getColor());
                if (!c.isFill()) {
                    d.drawCircle((int) c.getCenter().getX(), (int) c.getCenter().getY(), c.getR());
                } else {
                    d.fillCircle((int) c.getCenter().getX(), (int) c.getCenter().getY(), c.getR());
                }
            }
        }
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
