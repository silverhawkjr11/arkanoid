package geometry;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Point {
    /**
     *this func sets our point's x value to a new received value.
     * @param xAxis the new received value.
     * */
    public void setX(double xAxis) {
        this.x = xAxis;
    }

    private double x;
    /**
     *this func sets our point's y value to a new received value.
     * @param yAxis the new received value.
     * */
    public void setY(double yAxis) {
        this.y = yAxis;
    }

    private double y;
    // constructor
    /**
     * this is a constructor.
     * @param x represents our points x value.
     * @param y represents our points y value.
     * */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // distance -- return the distance of this point to the other point
    /**
     * @param other a point that we seek to calculate its distance from our point.
     * @return this func returns the distance from our point to a received point.
     * */
    public double distance(Point other) {
        double width = Math.abs(this.x - other.getX());
        double hight = Math.abs(this.y - other.getY());
        double distance = Math.sqrt(Math.pow(width, 2) + Math.pow(hight, 2));
        return distance;
    }

    // equals -- return true is the points are equal, false otherwise
    /**
     * @param other an other point that we seek to check if its equal to our point.
     * @return this func returns true if our point and the received point are equal and false
     * otherwise.
     * */
    public boolean equals(Point other) {
        if (this.x == other.getX() && this.y == other.getY()) {
            return true;
        }
        return false;
    }

    // Return the x and y values of this point\
    /**
     * @return this func returns our points x value.
     * */
    public double getX() {
        return this.x;
    }
    /**
     * @return this func returns our points y value.
     * */
    public double getY() {
        return this.y;
    }
}
