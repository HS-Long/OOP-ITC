import java.util.Scanner;

public class Exercise1 {
    public Exercise1(Point centre, Point point) {
        Ex1_Circle c = new Ex1_Circle(centre, point);
        c.printInfo();
    }

    int x, y;
    Scanner scanner = new Scanner(System.in);
    public Exercise1(){
        System.out.print("Enter centre point x: ");
        x = scanner.nextInt();
        System.out.print("Enter centre point y: ");
        y = scanner.nextInt();
        Point centre = new Point(x,y);
        System.out.print("Enter point x: ");
        x = scanner.nextInt();
        System.out.print("Enter point y: ");
        y = scanner.nextInt();
        Point point = new Point(x,y);
        Ex1_Circle c = new Ex1_Circle(centre, point);
        c.printInfo();
    }
}
