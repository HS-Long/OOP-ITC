import java.util.Scanner;

public class Exercise4 {
    Scanner scanner = new Scanner(System.in);
    Ex4_Services Ex4 = new Ex4_Services();
    private int choice = 0;
    public Exercise4() {
        do {
            System.out.println("1. List all courses");
            System.out.println("2. Find course by ID");
            System.out.println("3. Add new course");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Ex4.listAllCourses();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter course ID: ");
                    String ID1 = scanner.nextLine();
                    Ex4.findCourseByID(ID1);
                    break;
                case 3:
                    Ex4.addCourse();
                    break;
                case 4:
                    System.out.println("--------------------------");
                    System.out.println("GoodBye!");
                    System.out.println("--------------------------");
                    break;
                default:
                    System.out.println("--------------------------");
                    System.out.println("Invalid Input!");
                    System.out.println("--------------------------");
                    break;
            }
        }while (choice != 4);
    }
}
