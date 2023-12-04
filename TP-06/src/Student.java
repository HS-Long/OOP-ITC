import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int studentID;
    private String studentName;

    // Constructor
    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    // Getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    // Setter methods (optional)
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public static void addNewStudent(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student newStudent = new Student(studentID, studentName);
        studentList.add(newStudent);

        System.out.println("Student added successfully.");
    }

    public static void listStudents(ArrayList<Student> studentList) {
        System.out.println("\nList of Students:");
        for (Student student : studentList) {
            System.out.println("ID: " + student.getStudentID() + ", Name: " + student.getStudentName());
        }
    }

    public static void removeStudentByName(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student name to remove: ");
        String studentName = scanner.nextLine();

        boolean removed = false;
        for (Student student : studentList) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                studentList.remove(student);
                removed = true;
                System.out.println("Student removed successfully.");
                break; // Exit the loop after removing the first occurrence
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    public static void updateStudentInformation(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean found = false;
        for (Student student : studentList) {
            if (student.getStudentID() == studentID) {
                System.out.print("Enter new student name: ");
                String newStudentName = scanner.nextLine();
                student.setStudentName(newStudentName);

                System.out.println("Student information updated successfully.");
                found = true;
                break; // Exit the loop after updating the first occurrence
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
