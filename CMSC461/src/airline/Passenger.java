package airline;

public class Passenger {
	
	private double SSN;
	private String firstName;
	private String lastName;
	private int age;
	private String street;
	private int apartmentNum = 0;
	private String city;
	private String state;
	private int zipcode;
	private double homePhone = 0;
	private double workPhone = 0;
	
	public Passenger( double SSN, String firstName, String lastName, int age, String street, int aptNum, String city, String state, int zipcode, double homePhone, double workPhone) {
		this.SSN = SSN;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.street = street;
		this.apartmentNum = aptNum;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
	}

	public double getSSN() {
		return SSN;
	}

	public void setSSN(double sSN) {
		SSN = sSN;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getApartmentNum() {
		return apartmentNum;
	}

	public void setApartmentNum(int apartmentNum) {
		this.apartmentNum = apartmentNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public double getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(double homePhone) {
		this.homePhone = homePhone;
	}

	public double getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(double workPhone) {
		this.workPhone = workPhone;
	}
	
	
	
}
