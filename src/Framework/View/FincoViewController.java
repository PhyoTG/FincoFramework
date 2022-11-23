package Framework.View;

import java.util.Collection;

import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Customer;
import Framework.Operation.AddCompanyAccountOperation;
import Framework.Operation.AddPersonalAccountOperation;
import Framework.Operation.OperationManager;

public class FincoViewController implements FincoController {

	public static OperationManager Ops = new OperationManager();
	
	@Override
	public Customer addPersonAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String birthDate, String acctype) {
		AddPersonalAccountOperation addPerson = new AddPersonalAccountOperation(name, street, city, state, zip, email,birthDate,acctype,null);
		Ops.submit(addPerson);
		
		this.createAccount(addPerson.getCustomer(),accountNum, acctype);
		return addPerson.getCustomer();
	}

	@Override
	public Customer addCompanyAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String noEmployees, String acctype) {
		// TODO Auto-generated method stub
		AddCompanyAccountOperation addCompany = new AddCompanyAccountOperation(name, street, city, state, zip, email,noEmployees,acctype,null);
		Ops.submit(addCompany);
		
		this.createAccount(addCompany.getCustomer(),accountNum, acctype);
		return addCompany.getCustomer();
	}

	@Override
	public Account createAccount(Customer customer, String accountNum, String accType) {
		Account account = new Account(accountNum, customer, accType);

        customer.addAccount(account);
//        this.getAccounts().add(account);

        return account;
	}

	@Override
	public Collection<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateReport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entry withdraw(Account account, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry deposit(Account account, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
