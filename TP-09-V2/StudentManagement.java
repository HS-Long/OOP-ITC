import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/oopa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@seaklong2001@";
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection connection = null;
		List<Student> stdList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		StudentService studentService = new StudentService(connection);
		int choice=0;
		do {
			System.out.print("""
					****************************************
					Please select an option:
					1. Add new student
					2. List students
					3. Remove student by id
					4. Update student information by id
					5. Quit
					****************************************
					""");
			System.out.print("Enter your option: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
				case 1:
					System.out.print("Enter student name: ");
					String name = scanner.nextLine();
					System.out.print("Enter student date of birth: ");
					String dateOfBirth = scanner.nextLine();
					System.out.print("Enter student telephone number: ");
					String telephoneNumber = scanner.nextLine();
					System.out.print("Enter student city: ");
					String city = scanner.nextLine();
					Student std = new Student(name, dateOfBirth, telephoneNumber, city);
					studentService.addStudent(std);
					break;
				case 2:
					stdList = studentService.getStudentList();
					System.out.println("+----+--------------+------------+--------------+------------+");
					System.out.println("| ID |     Name     | Birth Date | Phone Number |    City    |");
					System.out.println("+----+--------------+------------+--------------+------------+");
					for(Student std1: stdList) {
						System.out.printf("| %2d | %12s | %10s | %12s | %10s |\n", std1.getId(), std1.getName(), std1.getDateOfBirth(), std1.getTelephoneNumber(), std1.getCity());
					}
					break;
				case 3:
					System.out.print("Please Enter Student ID: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					studentService.deleteStudent(id);
					break;
				case 4:
					System.out.print("Please enter student ID: ");
					int idUpdate = scanner.nextInt();
					scanner.nextLine();
					Student student = studentService.findStudentById(idUpdate);
					if(student != null) {
						System.out.print("Please enter new name: ");
						String nameUpdate = scanner.nextLine();
						System.out.print("Please enter new date of birth: ");
						String dobUpdate = scanner.nextLine();
						System.out.print("Please enter new phone number: ");
						String phoneUpdate = scanner.nextLine();
						System.out.print("Please enter new city: ");
						String cityUpdate = scanner.nextLine();
						if(!nameUpdate.isEmpty() && nameUpdate!=null) {
							student.setName(nameUpdate);
						}
						if(!dobUpdate.isEmpty() && dobUpdate != null) {
							student.setDateOfBirth(dobUpdate);
						}
						if(!phoneUpdate.isEmpty() && phoneUpdate != null) {
							student.setTelephoneNumber(phoneUpdate);
						}
						if(!cityUpdate.isEmpty() && cityUpdate!=null) {
							student.setCity(cityUpdate);
						}
						studentService.updateStudent(student);
					}else {
						System.out.println("No student found");
					}
					break;
				case 5:
					System.out.println("Good bye!");
					return;
				default:
					System.out.println("Invalid choice");
					break;
			}
		}while(choice!=5);

	}

}
