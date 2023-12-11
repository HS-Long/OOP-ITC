public class Ex1_Circle {
    Point centre;
    Point point;
    Point w1 = new Point(0,1);

    public Ex1_Circle(Point centre, Point point) {
        this.centre = centre;
        this.point = point;
    }

    public void printInfo(){
        System.out.println("Radius: " + (Math.round(radius()*100))/100.0);
        System.out.println("Area: " + (Math.round(area()*100))/100.0);
        System.out.println("Circumference: " + (Math.round(circumference()*100))/100.0);
    }


    double radius() {
        return centre.distance(point);
    }

    double area() {
        return Math.PI * Math.pow(radius(), 2);
    }

    double circumference() {
        return 2 * Math.PI * radius();
    }
}
