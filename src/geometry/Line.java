package geometry;

import java.awt.Color;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Line {
    private Point start;
    private Point end;
    /**
     * @return this func returns the color of the line.
     * */
    public Color getColor() {
        return color;
    }
    /**
     * this func sects the color of the line.
     * @param c : the line's new color.
     * */
    public void setColor(Color c) {
        this.color = c;
    }

    private Color color;

    // constructors
    /**
     * this is a constructor.
     * @param start represents the start point of a line.
     * @param end represents the end point of the line.
     * */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * this is a constructor.
     * @param x1 represents the x value of the start point of the line.
     * @param y1 represents the y value of the start point of the line.
     * @param x2 represents the x value of the end point of the line.
     * @param y2 represents the y value of the end point of the line.
     * */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    // Return the length of the line
    /**
     * @return the length of our line.
     * */
    public double length() {
        return start.distance(end);
    }

    // Returns the middle point of the line
    /**
     * @return the middle point of our line.
     * */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(x, y);
        return middle;
    }

    // Returns the start point of the line
    /**
     * @return the start point of our line.
     * */
    public Point start() {
        return this.start;
    }

    // Returns the end point of the line
    /**
     * @return the end point of our line.
     * */
    public Point end() {
        return this.end;
    }

    // Returns true if the lines intersect, false otherwise
    /**
     * this func checks is our line intersects with an other received line.
     * @param other represents the line that we want to check if our line intersects with.
     * @return this func returns true if our line intersects and false otherwise.
     * */
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) != null) {
            return true;
        }
        return false;
    }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.
//    public geometry.Point intersectionWithSaaeed(geometry.Line other) {
//        double intersectionX, intersectionY;
//        geometry.Point intersection = null;
//        double thisDeltaY = this.start.getY() - this.end.getY();
//        double thisDeltaX = this.start.getX() - this.end.getX();
//        double otherDeltaY = other.start.getY() - other.end.getY();
//        double otherDeltaX = other.start.getX() - other.end.getX();
//        if (this.start.getX() != this.end.getX() && other.start.getX() != other.end.getX()) //non parallel with y
//        {
//            double thisSlope = thisDeltaY / thisDeltaX;
//            double thisParameter = this.start.getY() - thisSlope * this.start.getX();
//            double otherSlope = otherDeltaY / otherDeltaX;
//            double otherParameter = other.start.getY() - otherSlope * other.start.getX();
//            if (otherSlope != thisSlope) {
//                intersectionX = (thisParameter - otherParameter) / (otherSlope - thisSlope);
//                intersectionY = thisSlope * intersectionX + thisParameter;
//                intersection = new geometry.Point(intersectionX, intersectionY);
//                if ((this.inRange(intersection.getX(), this.start.getX(), this.end.getX()))
//                        && this.inRange(intersection.getY(), this.start.getY(), this.end.getY())) {
//                    return intersection;
//                }
//                System.out.println("3");
//                return null;
//            }
//        } // when the two lines are not parallel to the y axis
//        if (this.start.getX() == this.end.getX()) {// only this line is parallel to the y axis.
//            double otherSlope = otherDeltaY / otherDeltaX;
//            double otherParameter = other.start.getY() - otherSlope * other.start.getX();
//            double possibleIntersectionY = otherSlope * this.start.getX() + otherParameter;
//            if (this.inRange(possibleIntersectionY, this.start.getY(), this.end.getY())) {
//                intersectionX = (possibleIntersectionY - otherParameter) / otherSlope;
//                intersection = new geometry.Point(intersectionX, possibleIntersectionY);
//            }
//            System.out.println("1");
//            return null;
//        }
//        if (other.start.getX() == other.end.getX()) {//only the other line is parallel with the y axis.
//            double thisSlope = thisDeltaY / thisDeltaX;
//            double thisParameter = this.start.getY() - thisSlope * this.start.getX();
//            double possibleIntersectionY = thisSlope * other.start.getX() + thisParameter;
//            if (this.inRange(possibleIntersectionY, other.start.getY(), other.end.getY())) {
//                intersectionX = (possibleIntersectionY - thisParameter) / thisSlope;
//                intersection = new geometry.Point(intersectionX, possibleIntersectionY);
//            }
//            System.out.println("5");
//            return null;
//        }
//        System.out.println("6");
//        return intersection;
//
//    }
    /**
     * this point returns the intersection point of our line and another received line
     * if the lines dont intersect the func returns null.
     * @param other the line that we seek to find its intersection point with our line.
     * @return the intersection point.
     * */
    public Point intersectionWith(Line other) {
       /* double intersectionX, intersectionY;
        double thisDeltaY = this.start.getY() - this.end.getY();
        double thisDeltaX = this.start.getX() - this.end.getX();
        double otherDeltaY = other.start.getY() - other.end.getY();
        double otherDeltaX = other.start.getX() - other.end.getX();
        double otherSlope, thisSlope, otherParameter, thisParameter;

        if (this.start.getX() == this.end.getX()
                && other.start.getX() != other.end.getX()) { // only this line is parallel to the y axis.
            otherSlope = otherDeltaY / otherDeltaX;
            otherParameter = other.start.getY() - otherSlope * other.start.getX();
            intersectionX = this.start.getX();
            intersectionY = otherSlope * intersectionX + otherParameter;
            if (this.inRange(new geometry.Point(intersectionX, intersectionY), this, other)) {
                geometry.Point intersection = new geometry.Point(intersectionX, intersectionY);
                return intersection;
            }
        } else if (other.start.getX() == other.end.getX()
                && this.start.getX() != this.end.getX()) { //only the other line is parallel with the y axis.
            thisSlope = thisDeltaY / thisDeltaX;
            thisParameter = this.start.getY() - thisSlope * this.start.getX();
            intersectionX = other.start.getX();
            intersectionY = thisSlope * intersectionX  + thisParameter;
            if (this.inRange(new geometry.Point(intersectionX, intersectionY), this, other)) {
                geometry.Point intersection = new geometry.Point(intersectionX, intersectionY);
                return intersection;
            }
        } else if (this.start.getX() != this.end.getX()
                && other.start.getX() != other.end.getX()) {
            thisSlope = thisDeltaY / thisDeltaX;
            thisParameter = this.start.getY() - thisSlope * this.start.getX();
            otherSlope = otherDeltaY / otherDeltaX;
            otherParameter = other.start.getY() - otherSlope * other.start.getX();
            if (otherSlope != thisSlope) {
                intersectionX = (thisParameter - otherParameter) / (otherSlope - thisSlope);
                intersectionY = thisSlope * intersectionX + thisParameter;
                geometry.Point intersection = new geometry.Point(intersectionX, intersectionY);
                if ((this.inRange(new geometry.Point(intersectionX, intersectionY), this, other))) {
                    return intersection;
                }
            }
        }
        return null;*/
        double devide = ((other.end.getY() - other.start.getY())
                * (this.end.getX() - this.start.getX()) - (other.end.getX()
                - other.start.getX()) * (this.end.getY() - this.start.getY()));
        double x = ((this.end.getX() - this.start.getX())
                * (this.start.getY() - other.start.getY())
                - (this.end.getY() - this.start.getY()) * (this.start.getX() - other.start.getX())) / devide;
        double y = ((other.end.getX() - other.start.getX())
                * (this.start.getY() - other.start.getY())
                - (other.end.getY() - other.start.getY()) * (this.start.getX() - other.start.getX())) / devide;
        double intersectionInX;
        double intersectionInY;
        if (y >= 0 && y <= 1 && x <= 1 && x >= 0) {
            intersectionInX = this.start.getX() + (y * (this.end.getX() - this.start.getX()));
            intersectionInY = this.start.getY() + (y * (this.end.getY() - this.start.getY()));
            Point p = new Point(intersectionInX, intersectionInY);
            return p;
        }
        return null;
    }
    /**
     * this func checks if a received point is in range of two received lines if it does returns
     * true and otherwise returns false.
     * @param intersection the supposed intersection point that we seek to see if its in the range.
     * @param l1 one of the lines.
     * @param l2 one of the lines.
     * @return the func returns true if its in range and false otherwise.
     * */
    boolean inRange(Point intersection, Line l1, Line l2) {
        boolean flag = true;
        //l1
        if (!(intersection.getX() >= Math.min(l1.start.getX(), l1.end.getX())
                && intersection.getX() <= Math.max(l1.start.getX(), l1.end.getX()))) {
            flag = false;
        }
        if (!(intersection.getY() >= Math.min(l1.start.getY(), l1.end.getY())
                && intersection.getY() <= Math.max(l1.start.getY(), l1.end.getY()))) {
            flag = false;
        }
        //l2
        if (!(intersection.getX() >= Math.min(l2.start.getX(), l2.end.getX())
                && intersection.getX() <= Math.max(l2.start.getX(), l2.end.getX()))) {
            flag = false;
        }
        if (!(intersection.getY() >= Math.min(l2.start.getY(), l2.end.getY())
                && intersection.getY() <= Math.max(l2.start.getY(), l2.end.getY()))) {
            flag = false;
        }
        return flag;
    }
    /**
     * this func checks if a received point exists within our line.
     * @param intersection the point that we seek to check.
     * @return true if the point exists and false otherwise.
     * */
    public boolean inRangeOneLine(Point intersection) {
        if (intersection.getX() <= Math.max(this.start.getX(), this.end.getX())
                && intersection.getX() >= Math.min(this.start.getX(), this.end.getX())) {
            if (intersection.getY() <= Math.max(this.start.getY(), this.end.getY())
            && intersection.getY() >= Math.min(this.start.getY(), this.end.getY())) {
                return true;
            }
        }
        return false;
    }

    // equals -- return true is the lines are equal, false otherwise
    /**
     * this func receives another line and checks if its equal to our line.
     * @param other represents the line that we want to see if its equal to our line.
     * @return returns true if the two lines are equal and false otherwise.
     * */
    public boolean equals(Line other) {
        double thisDeltaY = this.start.getY() - this.end.getY();
        double thisDeltaX = this.start.getX() - this.end.getX();
        double thisSlope = thisDeltaY / thisDeltaX;
        double thisParameter = this.start.getY() - thisSlope * this.start.getX();
        double otherDeltaY = other.start.getY() - other.end.getY();
        double otherDeltaX = other.start.getX() - other.end.getX();
        double otherSlope = otherDeltaY / otherDeltaX;
        double otherParameter = other.start.getY() - otherSlope * other.start.getX();
        if (thisSlope == otherSlope && thisParameter == otherParameter) {
            return true;
        }
        return false;
    }
    /**
     * this func looks for the closest intersection with our line and a received rectangle.
     * @param rect the rectangle that we need to check.
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this).isEmpty()) {
            return null;
        }
        Point chosen = rect.intersectionPoints(this).get(0);
        for (Point point : rect.intersectionPoints(this)) {
            if (point.distance(this.start) < chosen.distance(this.start)) {
                chosen = point;
            }
        }
        return chosen;
    }
}
