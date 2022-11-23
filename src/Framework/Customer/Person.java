package Framework.Customer;

public class Person extends Customer{

	private String birthDate;
	
	public Person(String name, String street, String city, String state, Integer zip, String email,String bdate) {
		super(name, street, city, state, zip, email);
		this.birthDate = bdate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
