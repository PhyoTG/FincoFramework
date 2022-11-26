package Framework.View;

import java.util.Collection;

import Framework.DataManager;
import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Customer;
import Framework.Operation.AddCompanyAccountOperation;
import Framework.Operation.AddDepositOperation;
import Framework.Operation.AddInterestOperation;
import Framework.Operation.AddPersonalAccountOperation;
import Framework.Operation.AddWithdrawOperation;
import Framework.Operation.OperationManager;

public class FincoController implements IFincoController {

	public static OperationManager Ops = new OperationManager();
	public static DataManager finco = new DataManager();
	
	@Override
	public Customer addPersonAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String birthDate, String acctype) {
		AddPersonalAccountOperation addPerson = new AddPersonalAccountOperation(name, street, city, state, zip, email,birthDate,acctype,finco);
		Ops.submit(addPerson);
		
		this.createAccount(addPerson.getCustomer(),accountNum, acctype);
		return addPerson.getCustomer();
	}

	@Override
	public Customer addCompanyAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String noEmployees, String acctype) {
		AddCompanyAccountOperation addCompany = new AddCompanyAccountOperation(name, street, city, state, zip, email,noEmployees,acctype,finco);
		Ops.submit(addCompany);
		
		this.createAccount(addCompany.getCustomer(),accountNum, acctype);
		return addCompany.getCustomer();
	}

	@Override
	public Account createAccount(Customer customer, String accountNum, String accType) {
		Account account = new Account(accountNum, customer, accType);

        customer.addAccount(account);
        this.getAccounts().add(account);

        return account;
	}

	@Override
	public Collection<Account> getAccounts() {
		// TODO Auto-generated method stub
		return this.finco.accountsList;
	}

	@Override
	public void generateReport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		AddInterestOperation interest = new AddInterestOperation(this.finco);
		Ops.submit(interest);
		this.finco.writeData();
	}

	@Override
	public Entry withdraw(Account account, double amount) {
		// TODO Auto-generated method stub
		
		AddWithdrawOperation addWithdraw = new AddWithdrawOperation(account, amount);
		Ops.submit(addWithdraw);
		this.finco.writeData();
		return addWithdraw.getEntry();
		
	}

	@Override
	public Entry deposit(Account account, double amount) {
		AddDepositOperation addDeposit = new AddDepositOperation(account, amount);
		Ops.submit(addDeposit);
		this.finco.writeData();
		return addDeposit.getEntry();
		
	}

	@Override
	public Customer addCreditAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String noEmployees, String acctype) {
		// TODO Auto-generated method stub
		return null;
	}

}
