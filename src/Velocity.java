import geometry.Point;

/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Velocity {

    private double dx;

    private double dy;
    // constructor
    /**
     * this is a constructor.
     * @param dx a double that represents our velocity dx value.
     * @param dy a double that represents our velocity dy value.
     * */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * @return this func returns our dx value.
     * */
    public double getDx() {
        return this.dx;
    }
    /**
     * this func sets our dx val to a new received val.
     * @param dxNew the new received val.
     * */
    public void setDx(double dxNew) {
        this.dx = dxNew;
    }
    /**
     * @return this func returns our dy value.
     * */
    public double getDy() {
        return this.dy;
    }
    /**
     * this func sets our dy val to a new received val.
     * @param dyNew the new received val.
     * */
    public void setDy(double dyNew) {
        this.dy = dyNew;
    }
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    /**
     * this func receives a point and then applies our velocity to it and then returns it.
     * @param p a point that we seek to apply our velocity to.
     * @return the point that we received after we applied our velocity to ot.
     * */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newPoint;
    }
    /**
     * @param angle represents the direction of the new velocity.
     * @param speed represents the speed of the new velocity.
     * @return this func receives an angle and a speed then calculates dx and dy creates a velocity variable
     * accordingly and returns it.
     * */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
}