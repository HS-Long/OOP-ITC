import java.io.*;
import java.util.Scanner;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

public class StudentInformationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Information System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student's information:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        try {
            validateDateOfBirth(dob);
        } catch (InvalidDataFormatException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("Telephone Number: ");
        String phoneNumber = scanner.nextLine();
        try {
            validatePhoneNumber(phoneNumber);
        } catch (InvalidDataFormatException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("City: ");
        String city = scanner.nextLine();

        // Save student information to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("studentList.txt", true))) {
            writer.write(name + "," + dob + "," + phoneNumber + "," + city);
            writer.newLine();
            System.out.println("Student added successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the student information.");
            e.printStackTrace();
        }
    }

    private static void validateDateOfBirth(String dob) throws InvalidDataFormatException {
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidDataFormatException("Invalid date of birth format. Please use YYYY-MM-DD.");
        }
    }

    private static void validatePhoneNumber(String phoneNumber) throws InvalidDataFormatException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidDataFormatException("Invalid phone number format. Please enter 10 digits.");
        }
    }

    private static void viewStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("studentList.txt"))) {
            System.out.println("List of Students:");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length == 4) {
                    String name = studentData[0];
                    String dob = studentData[1];
                    String phoneNumber = studentData[2];
                    String city = studentData[3];

                    System.out.println("Name: " + name);
                    System.out.println("Date of Birth: " + dob);
                    System.out.println("Telephone Number: " + phoneNumber);
                    System.out.println("City: " + city);
                    System.out.println("----------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading student information.");
            e.printStackTrace();
        }
    }
}
