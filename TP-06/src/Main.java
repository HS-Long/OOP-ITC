import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Welcome to My Project!");
            System.out.println("1. Circle.");
            System.out.println("2. Student.");
            System.out.println("3. PC in DICE’s Lab.");
            System.out.println("4. Courses.");
            System.out.println("5. New Year Gift Shop.");
            System.out.println("6. Exit.");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Scanner scanner = new Scanner(System.in);

                    // Taking input for the center point
                    System.out.print("Enter x-coordinate of the center: ");
                    int centerX = scanner.nextInt();
                    System.out.print("Enter y-coordinate of the center: ");
                    int centerY = scanner.nextInt();

                    // Creating the center point
                    Point center = new Point(centerX, centerY);

                    // Taking input for a point on the circle
                    System.out.print("Enter x-coordinate of a point on the circle: ");
                    int pointX = scanner.nextInt();
                    System.out.print("Enter y-coordinate of a point on the circle: ");
                    int pointY = scanner.nextInt();

                    // Creating a point on the circle
                    Point pointOnCircle = new Point(pointX, pointY);

                    // Creating a circle using the user-input points
                    Circle circle = new Circle(center, pointOnCircle);

                    // Testing the methods in the Circle class
                    System.out.println("Length of the circle: " + circle.calculateLength());
                    System.out.println("Radius of the circle: " + circle.calculateRadius());
                    System.out.println("Surface area of the circle: " + circle.calculateSurface());

                    break;
                case 2:
                    Scanner sc = new Scanner(System.in);
                    ArrayList<Student> studentList = new ArrayList<>();

                    int choic;
                    do {
                        // Display menu
                        System.out.println("\nMenu:");
                        System.out.println("1. Add new student");
                        System.out.println("2. List students");
                        System.out.println("3. Remove student by name");
                        System.out.println("4. Update student information by id");
                        System.out.println("5. Quit");

                        System.out.print("Enter your choice (1-5): ");
                        choic = sc.nextInt();
                        sc.nextLine(); // Consume the newline character

                        switch (choic) {
                            case 1:
                                Student.addNewStudent(studentList, sc);
                                break;
                            case 2:
                                Student.listStudents(studentList);
                                break;
                            case 3:
                                Student.removeStudentByName(studentList, sc);
                                break;
                            case 4:
                                Student.updateStudentInformation(studentList, sc);
                                break;
                            case 5:
                                System.out.println("Quitting the program. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        }
                    } while (choic != 5);
                    break;
                case 3:
                    Pc[] pcs = new Pc[10]; // Assuming there are 10 PCs in the room, adjust as needed

                    // Initialize PCs
                    for (int i = 0; i < pcs.length; i++) {
                        pcs[i] = new Pc("PC" + (i + 1));
                    }

                    Scanner scannerr = new Scanner(System.in);

                    int choicee;
                    do {
                        System.out.println("Menu:");
                        System.out.println("1. List all PCs");
                        System.out.println("2. List all damaged PCs");
                        System.out.println("3. List all good PCs");
                        System.out.println("4. Mark a PC as damaged");
                        System.out.println("5. Mark a PC as not damaged");
                        System.out.println("6. Quit");

                        System.out.print("Enter your choice: ");
                        choicee = scannerr.nextInt();

                        switch (choicee) {
                            case 1:
                                Pc.listAllPCs(pcs);
                                break;
                            case 2:
                                Pc.listDamagedPCs(pcs);
                                break;
                            case 3:
                                Pc.listGoodPCs(pcs);
                                break;
                            case 4:
                                Pc.markPCAsDamaged(pcs, scannerr);
                                break;
                            case 5:
                                Pc.markPCAsNotDamaged(pcs, scannerr);
                                break;
                            case 6:
                                System.out.println("Exiting program. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                    } while (choicee != 6);
                    break;

                case 4:
                    Scanner sca = new Scanner(System.in);
                    ArrayList<Course> courseList = new ArrayList<>();

                    int choi;
                    do {
                        // Display menu
                        System.out.println("\nMenu:");
                        System.out.println("1. List all courses");
                        System.out.println("2. Find courses by name");
                        System.out.println("3. Add new course");
                        System.out.println("4. Quit");

                        System.out.print("Enter your choice (1-4): ");
                        choice = sca.nextInt();
                         // Consume the newline character

                        switch (choice) {
                            case 1:
                                Course.listAllCourses(courseList);
                                break;
                            case 2:
                                Course.findCoursesByName(courseList, sca);
                                break;
                            case 3:
                                Course.addNewCourse(courseList, sca);
                                break;
                            case 4:
                                System.out.println("Quitting the program. Goodbye!");
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        }
                    } while (choice != 4);
                    break;

                case 5:
                    // Code for option 5
                    break;

                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != 8);
    }
}
