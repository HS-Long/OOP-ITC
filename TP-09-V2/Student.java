
public class Student {
	private int id;
	private String name;
	private String dateOfBirth;
	private String telephoneNumber;
	private String city;
	public Student() {
		
	}
	public Student(int id, String name, String dateOfBirth, String telephoneNumber, String city) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.telephoneNumber = telephoneNumber;
		this.city = city;
	}
	public Student(String name, String dateOfBirth, String telephoneNumber, String city) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.telephoneNumber = telephoneNumber;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", telephoneNumber="
				+ telephoneNumber + ", city=" + city + "]";
	}
	
	
}
