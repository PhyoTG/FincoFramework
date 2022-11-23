package Bank.Operation;

import Bank.Bank;
import Framework.Finco;
import Framework.Customer.Company;
import Framework.Customer.Customer;
import Framework.Operation.Operation;

public class BankCompanyAccountOperation implements Operation{
	
	private String name;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String email;
    private Customer customer;
    private String noOfEmployees;
    private String accountType;
    private Bank bank;
    
	public BankCompanyAccountOperation(String name,
		            String street,
		            String city,
		            String state,
		            Integer zip,
		            String email,
		            String noOfEmployees,
		            String acctype,
		            Bank bank) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.noOfEmployees = noOfEmployees;
		this.accountType = acctype;
		this.bank = bank;
		}

	@Override
	public void execute() {
		setCustomer(new Company(name, street, city, state, zip, email,noOfEmployees));
		System.out.println(this.customer.getName());
		this.bank.writeData();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
