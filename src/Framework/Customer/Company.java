package Framework.Customer;

public class Company extends Customer{

	private String noOfEmployees;
	
	public Company(String name, String street, String city, String state, Integer zip, String email,String empNum) {
		super(name, street, city, state, zip, email);
		this.noOfEmployees = empNum;
	}

	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

}
