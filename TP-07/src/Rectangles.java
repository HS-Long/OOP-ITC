class Rectangles extends Shape{
    double width;
    double height;

    public Rectangles(double width, double height) {
        super("Rectangles");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
class Circles extends Shape{
     double radius;

     public Circles(double radius) {
         super("Circles");
         this.radius = radius;
     }

     @Override
     public double calculateArea() {
         return Math.PI * radius * radius;
     }

     @Override
     public double calculatePerimeter() {
         return 2 * Math.PI * radius;
     }

}
 abstract class Shape {
     String name;

     public Shape(String name) {
         this.name = name;
     }
     public abstract double calculateArea();
     public abstract double calculatePerimeter();

     public void displayShape() {
         System.out.println("======================================");
         System.out.println("Name: " + name);
         System.out.println("Area: " + calculateArea());
         System.out.println("Perimeter: " + calculatePerimeter());
         System.out.println("======================================");
     }

}
class Triangle extends Shape {
    double base;
    double height;
    double side1;
    double side2;

    public Triangle(double base, double height, double side1, double side2) {
        super("Triangle");
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public double calculatePerimeter() {
        return base + side1 + side2;
    }
}