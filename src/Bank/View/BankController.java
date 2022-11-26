package Bank.View;

import java.util.Collection;

import Bank.BankDataManager;
import Bank.Operation.BankCompanyAccountOperation;
import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Customer;
import Framework.Operation.AddDepositOperation;
import Framework.Operation.AddPersonalAccountOperation;
import Framework.Operation.AddWithdrawOperation;
import Framework.View.IFincoController;
import Framework.View.FincoController;

public class BankController extends FincoController implements IFincoController{
	
	public static BankDataManager bank = new BankDataManager();
	
    public BankController() {
        super();
    }

	@Override
	public Customer addPersonAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String birthDate, String acctype) {
		AddPersonalAccountOperation addPerson = new AddPersonalAccountOperation(name, street, city, state, zip, email,birthDate,acctype,bank);
		Ops.submit(addPerson);
		
		this.createAccount(addPerson.getCustomer(),accountNum, acctype);
		return addPerson.getCustomer();
	}

	@Override
	public Customer addCompanyAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String noEmployees, String acctype) {
		BankCompanyAccountOperation addCompany = new BankCompanyAccountOperation(name, street, city, state, zip, email,noEmployees,acctype,bank);
		Ops.submit(addCompany);
		
		this.createAccount(addCompany.getCustomer(),accountNum, acctype);
		return addCompany.getCustomer();
	}

	@Override
	public Account createAccount(Customer customer, String accountNum, String acctype) {
		Account account = new Account(accountNum, customer, acctype);

        customer.addAccount(account);
        this.getAccounts().add(account);

        return account;
	}

	@Override
	public Collection<Account> getAccounts() {
		// TODO Auto-generated method stub
		return this.bank.accountsList;
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
		AddWithdrawOperation addWithdraw = new AddWithdrawOperation(account, amount);
		Ops.submit(addWithdraw);
		this.bank.writeData();
		return addWithdraw.getEntry();
	}

	@Override
	public Entry deposit(Account account, double amount) {
		AddDepositOperation addDeposit = new AddDepositOperation(account, amount);
		Ops.submit(addDeposit);
		this.bank.writeData();
		return addDeposit.getEntry();
	}
}
