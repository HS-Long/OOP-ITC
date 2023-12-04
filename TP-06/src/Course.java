import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String courseCode;
    private String courseName;

    // Constructor
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    // Setter methods (optional)
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public static void listAllCourses(ArrayList<Course> courseList) {
        System.out.println("\nList of Courses:");
        for (Course course : courseList) {
            System.out.println("Code: " + course.getCourseCode() + ", Name: " + course.getCourseName());
        }
    }

    public static void findCoursesByName(ArrayList<Course> courseList, Scanner scanner) {
        System.out.print("Enter course name to find: ");
        String courseName = scanner.nextLine();

        boolean found = false;
        for (Course course : courseList) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                System.out.println("Course Code: " + course.getCourseCode() + ", Name: " + course.getCourseName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No courses found with the given name.");
        }
    }

    public static void addNewCourse(ArrayList<Course> courseList, Scanner scanner) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        Course newCourse = new Course(courseCode, courseName);
        courseList.add(newCourse);

        System.out.println("Course added successfully.");
    }
}
