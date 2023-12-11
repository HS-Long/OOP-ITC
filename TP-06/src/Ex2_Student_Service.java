import java.util.ArrayList;
import java.util.Scanner;

public class Ex2_Student_Service {
    ArrayList<Ex2_Student> students = new ArrayList<Ex2_Student>();
    Scanner scanner = new Scanner(System.in);
    private String name;
    private String ID;
    public void addStudent(String name, String ID) {
        Ex2_Student student = new Ex2_Student();
        student.setName(name);
        student.setID(ID);
        this.students.add(student);
    }

    public void removeStudentByName(String name) {
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("--------------------------");
            System.out.println("Student not found");
            System.out.println("--------------------------");
        }
    }

    public void updateByInfomationByID(String ID) {
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).ID().equals(ID)) {
                System.out.print("Enter new name: ");
                students.get(i).setName(scanner.nextLine());
                System.out.print("Enter new ID: ");
                students.get(i).setID(scanner.nextLine());
            }
        }
        if (!check) {
            System.out.println("--------------------------");
            System.out.println("Student not found");
            System.out.println("--------------------------");
        }
    }

    public void showAllStudent() {
        if (students.size() == 0) {
            System.out.println("No student");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("Name: " + students.get(i).getName());
                System.out.println("ID: " + students.get(i).ID());
                System.out.println("--------------------------");
            }
        }
    }
}
