package geometry;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Rectangle {
    private Point upperLeft;
    private Point upperRight;
    private Point lowerLeft;
    private Point lowerRight;
    private Line upperEdge;
    private Line lowerEdge;
    private Line rightEdge;
    private Line leftEdge;
    private double width;
    private double height;
    /**
     * @return the color of our rectangle.
     * */
    public Color getColor() {
        return color;
    }

    private Color color;
    // Create a new rectangle with location and width/height.
    /**
     * this func is to Create a new rectangle with location and width/height.
     * @param upperLeft represents the upper left angle of our rectangle.
     * @param width represents the width of our rectangle.
     * @param height represents the height of our rectangle.
     * */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.width = width;
        this.height = height;
        this.upperEdge = new Line(this.upperLeft, this.upperRight);
        this.lowerEdge = new Line(this.lowerLeft, this.lowerRight);
        this.rightEdge = new Line(this.upperRight, this.lowerRight);
        this.leftEdge = new Line(this.upperLeft, this.lowerLeft);
    }
    /**
     * this is a constructor.
     * @param height represents the height of our rectangle.
     * @param width represents the width of our rectangle.
     * @param upperLeft represents the upper left point of our rectangle.
     * @param color represents the color of our rectangle.
     * */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.width = width;
        this.height = height;
        this.upperEdge = new Line(this.upperLeft, this.upperRight);
        this.lowerEdge = new Line(this.lowerLeft, this.lowerRight);
        this.rightEdge = new Line(this.upperRight, this.lowerRight);
        this.leftEdge = new Line(this.upperLeft, this.lowerLeft);
        this.color = color;
    }
    /**
     * @param line represents that we seek to find its intersection with our rectangle.
     * @return Return a (possibly empty) List of intersection points
     * with the specified line.
     * */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new LinkedList<>();
        if (this.upperEdge.isIntersecting(line)) {
            intersections.add(this.upperEdge.intersectionWith(line));
        }
        if (this.lowerEdge.isIntersecting(line)) {
            intersections.add(this.lowerEdge.intersectionWith(line));
        }
        if (this.leftEdge.isIntersecting(line)) {
            intersections.add(this.leftEdge.intersectionWith(line));
        }
        if (this.rightEdge.isIntersecting(line)) {
            intersections.add(this.rightEdge.intersectionWith(line));
        }
        return intersections;
    }

    /**
     * @return Return the width and height of the rectangle.
     * */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return Return the height and height of the rectangle.
     * */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return Returns the upper-left point of the rectangle.
     * */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * @return the upper edge of our rectangle as a line.
     * */
    public Line getUpperEdge() {
        return upperEdge;
    }
    /**
     * @return the lower edge of our rectangle as a line.
     * */
    public Line getLowerEdge() {
        return lowerEdge;
    }
    /**
     * @return the right edge of our rectangle as a line.
     * */
    public Line getRightEdge() {
        return rightEdge;
    }
    /**
     * @return the left edge of our rectangle as a line.
     * */
    public Line getLeftEdge() {
        return leftEdge;
    }
    /**
     * this func draws our rectangle on a received drawSurface.
     * @param drawSurface the drawSurface that we seek to draw our rectangle on.
     * */
    public void drawOnDrawsurface(DrawSurface drawSurface) {
        drawSurface.setColor(this.color);
        drawSurface.fillRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(), (int) this.width,
                (int) this.height);
        drawSurface.setColor(Color.BLACK);
        drawSurface.drawRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(), (int) this.width,
                (int) this.height);
    }
}