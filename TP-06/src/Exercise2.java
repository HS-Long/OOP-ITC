import java.util.Scanner;

public class Exercise2 {
    Scanner scanner = new Scanner(System.in);
    Ex2_Student_Service student = new Ex2_Student_Service();
    int choice;
    public Exercise2(){
        do{
            System.out.println("1. Add student");
            System.out.println("2. Remove student by name");
            System.out.println("3. Update student by ID");
            System.out.println("4. Show all student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String ID = scanner.nextLine();
                    student.addStudent(name, ID);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String nameRemove = scanner.nextLine();
                    student.removeStudentByName(nameRemove);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    String IDUpdate = scanner.nextLine();
                    student.updateByInfomationByID(IDUpdate);
                    break;
                case 4:
                    System.out.println("--------------------------");
                    student.showAllStudent();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    System.exit(0);
                default:
                    System.out.println("--------------------------");
                    System.out.println("Invalid choice");
                    System.out.println("--------------------------");
                    break;
            }
        }while (choice != 0);
    }
}
