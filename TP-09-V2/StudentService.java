import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
	private Connection connection;
	public StudentService(Connection connection) {
		this.connection = connection;
	}
	
	public List<Student> getStudentList(){
		List<Student> studentList = new ArrayList<>();
		String query = "select * from student;";
		try {
			Statement stm = connection.createStatement();
			ResultSet resultSet = stm.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String dateOfBirth = resultSet.getString("date_of_birth");
				String telephoneNumber = resultSet.getString("telephone_number");
				String city = resultSet.getString("city");
				
				Student std = new Student(id, name, dateOfBirth, telephoneNumber, city);
				studentList.add(std);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return studentList;
	}
	
	public void addStudent(Student student) {
		String query = "insert into student(name, date_of_birth, telephone_number, city) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStm = connection.prepareStatement(query);
			preparedStm.setString(1, student.getName());
			preparedStm.setString(2, student.getDateOfBirth());
			preparedStm.setString(3, student.getTelephoneNumber());
			preparedStm.setString(4, student.getCity());
			preparedStm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int id) {
		String query = "delete from student where id = ?;";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, id);
			int rowAffected = preparedStatement.executeUpdate();
			if(rowAffected>0) {
				System.out.println("Student deleted successfully");
			}else {
				System.out.println("No student found!!!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(Student student) {
		String query = "update student set name=?, date_of_birth=?, telephone_number=?, city=? where id = ?;";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getDateOfBirth());
			preparedStatement.setString(3, student.getTelephoneNumber());
			preparedStatement.setString(4, student.getCity());
			preparedStatement.setInt(5, student.getId());
			int rowAffected = preparedStatement.executeUpdate();
			if(rowAffected>0) {
				System.out.println("Student updated successfully");
			}else {
				System.out.println("No student found!!!");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student findStudentById(int id) {
		String query = "select * from student where id = ?";
		Student stdResult = null;
		try(PreparedStatement preparedStm = connection.prepareStatement(query)){
			preparedStm.setInt(1, id);
			ResultSet resultSet = preparedStm.executeQuery();
			while(resultSet.next()) {
				stdResult = new Student();
				stdResult.setId(resultSet.getInt("id"));
				stdResult.setName(resultSet.getString("name"));
				stdResult.setDateOfBirth(resultSet.getString("date_of_birth"));
				stdResult.setTelephoneNumber(resultSet.getString("telephone_number"));
				stdResult.setCity(resultSet.getString("city"));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return stdResult;
	}
	
}
