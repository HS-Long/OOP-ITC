import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex4_Services {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Ex4_AMS_Courses> courses = new ArrayList<Ex4_AMS_Courses>();
    private String name, ID;
    public Ex4_Services(){
        addCourse("Linear Algebra", "AGL");
        addCourse("Calculus 1", "CAL1");
        addCourse("Calculus 2", "CAL2");
        addCourse("Calculus 3", "CAL3");
        addCourse("Discrete Mathematics", "DIS");
        addCourse("Probability and Statistics", "PAS");
        addCourse("Numerical Analysis", "NUM");
        addCourse("Differential Equations", "DEQ");
        addCourse("Optimization", "OPT");
        addCourse("Graph Theory", "GTH");
        addCourse("Data Structures and Algorithms", "DSA");
        addCourse("Object Oriented Programming", "OOP");
        addCourse("Computer Architecture", "ARC");
        addCourse("Operating Systems", "OS");
        addCourse("Computer Networks", "NET");
        addCourse("Database Management Systems", "DBMS");
        addCourse("Software Engineering", "SE");
        addCourse("Computer Graphics", "CG");
        addCourse("Artificial Intelligence", "AI");
        addCourse("Computer Vision", "CV");
        addCourse("Machine Learning", "ML");
        addCourse("Deep Learning", "DL");
        addCourse("Natural Language Processing", "NLP");
        addCourse("Computer Security", "SEC");
        addCourse("Computer Forensics", "FOR");
        addCourse("Cryptography", "CRY");
    }

    public void addCourse(String name, String ID){
        Ex4_AMS_Courses course = new Ex4_AMS_Courses(name, ID);
        this.courses.add(course);
    }

    public void addCourse(){
        System.out.println("--------------------------");
        System.out.print("Enter course name: ");
        name = scanner.nextLine();
        System.out.print("Enter course ID: ");
        ID = scanner.nextLine();
        Ex4_AMS_Courses course = new Ex4_AMS_Courses(name, ID);
        this.courses.add(course);
        System.out.println("Course added successfully!");
        System.out.println("--------------------------");
    }

    public void listAllCourses(){
        System.out.println("--------------------------");
        System.out.println("List of all courses:");
        for (Ex4_AMS_Courses course : courses){
            System.out.println(course.getName() + " - " + course.getID());
        }
        System.out.println("--------------------------");
    }

    public void findCourseByID(String ID){
        boolean found = false;
        System.out.println("--------------------------");
        System.out.println("Loading...");
        for (Ex4_AMS_Courses course : courses){
            if (course.getID().equals(ID)){
                System.out.printf("Course found: %s - %s\n", course.getName(), course.getID());
                System.out.println("--------------------------");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("--------------------------");
            System.out.println("Course not found");
            System.out.println("--------------------------");
        }
    }
}
