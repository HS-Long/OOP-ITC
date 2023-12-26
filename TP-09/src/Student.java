import java.io.*;
import java.util.Scanner;

public class Student {

    private static final String FILE_NAME = "studentList.txt";
    private static int studentIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student by ID");
            System.out.println("4. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner);
                    break;
                case "2":
                    viewStudents();
                    break;
                case "3":
                    deleteStudentById(scanner);
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {

        try {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            validateDateOfBirth(dob);

            System.out.print("Enter telephone number: ");
            String phone = scanner.nextLine();
            validatePhoneNumber(phone);

            System.out.print("Enter city: ");
            String city = scanner.nextLine();

            int studentId = studentIdCounter++;
            String studentInfo = studentId + ", " + name + ", " + dob + ", " + phone + ", " + city + "\n";
            saveToFile(studentInfo);
            System.out.println("Student added successfully. Student ID: " + studentId);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private static void deleteStudentById(Scanner scanner) {
        System.out.print("Enter the student ID to delete: ");
        int studentIdToDelete = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            File inputFile = new File(FILE_NAME);
            File tempFile = new File("tempStudentList.txt");

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(", ");
                    int studentId = Integer.parseInt(parts[0]);

                    if (studentId != studentIdToDelete) {
                        bw.write(line + "\n");
                    }
                }
            }

            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                System.out.println("Student with ID " + studentIdToDelete + " deleted successfully.");
            } else {
                System.out.println("Error deleting student. Please try again.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No student data found.");
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }

    private static void validateDateOfBirth(String dob) throws IllegalArgumentException {
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        // Further validation can be added here
    }

    private static void validatePhoneNumber(String phone) throws IllegalArgumentException {
        // Add phone number validation logic
    }

    private static void saveToFile(String studentInfo) throws IOException {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(studentInfo);
        }
    }

    private static void viewStudents() {
        try {
            try (FileReader fr = new FileReader(FILE_NAME);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No student data found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
