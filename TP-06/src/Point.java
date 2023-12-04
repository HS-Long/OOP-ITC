import java.lang.Math;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
class Circle {
    private Point center;
    private Point pointOnCircle;

    public Circle(Point center, Point pointOnCircle) {
        this.center = center;
        this.pointOnCircle = pointOnCircle;
    }
    public double calculateLength(){
        double length = Math.sqrt(Math.pow(pointOnCircle.getX() - center.getX(),2));
        return length;
    }
    public double calculateRadius(){
        return calculateLength();
    }
    public double calculateSurface() {
        // Using the formula for the surface area of a circle
        double radius = calculateRadius();
        return Math.PI * Math.pow(radius, 2);
    }
}





