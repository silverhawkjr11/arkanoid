package geometry;

import java.awt.Color;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Circle {
    private Color color;
    /**
     * @return this func returns if the circle is for filling.
     * */
    public boolean isFill() {
        return fill;
    }

    private boolean fill;
    /**
     * @return this func returns our r value.
     * */
    public int getR() {
        return r;
    }

    private int r;
    /**
     * @return this func returns our center value.
     * */
    public Point getCenter() {
        return center;
    }

    private Point center;
    /**
     * this is a constructor.
     * @param c : represents the circle's center point.
     * @param radius : represents the circle's radius.
     * @param color1 : represents the circle's color.
     * @param fill : is a checker to see if the circle is for fill.
     * */
    public Circle(Point c, int radius, Color color1, boolean fill) {
        this.center = c;
        this.r = radius;
        this.color = color1;
        this.fill = fill;
    }
    /**
     * @return the circle's color.
     * */
    public Color getColor() {
        return color;
    }
}
