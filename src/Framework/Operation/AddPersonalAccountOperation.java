package Framework.Operation;

import Framework.Finco;
import Framework.Customer.Customer;
import Framework.Customer.Person;
import Framework.DB.Database;

public class AddPersonalAccountOperation implements Operation{

	private String name;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String email;
    private Customer customer;
    private String birthDate;
    private String accountType;
    private Finco finCo;

    public AddPersonalAccountOperation(String name,
                              String street,
                              String city,
                              String state,
                              Integer zip,
                              String email,
                              String birthDate,
                              String acctype,
                              Finco finCo) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.birthDate = birthDate;
        this.accountType = acctype;
        this.finCo = finCo;
    }
	
	@Override
	public void execute() {
		setCustomer(new Person(name, street, city, state, zip, email,birthDate));
		System.out.println(this.customer.getName());
		this.finCo.customers.add(this.customer);
		// add to database ... 
		this.finCo.writeData();
	}

	@Override
	public void undo() {
		
	}

	@Override
	public void redo() {
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
