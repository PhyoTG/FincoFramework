package CreditCard.View;

import java.util.Collection;

import CreditCard.CreditCardDataManager;
import CreditCard.Operation.AddCreditCardAccountOperation;
import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Customer;
import Framework.Operation.AddDepositOperation;
import Framework.Operation.AddWithdrawOperation;
import Framework.View.FincoController;
import Framework.View.IFincoController;

public class CreditCardController extends FincoController implements IFincoController{
	
	public static CreditCardDataManager credit = new CreditCardDataManager();
	
    public CreditCardController() {
        super();
    }

	@Override
	public Customer addCreditAccount(String accountNum, String name, String street, String city, String state,
			Integer zip, String email, String noEmployees, String acctype) {
		AddCreditCardAccountOperation addCredit = new AddCreditCardAccountOperation(name, street, city, zip, email,noEmployees,acctype,credit);
		Ops.submit(addCredit);
		
		this.createAccount(addCredit.getCustomer(),accountNum, acctype);
		return addCredit.getCustomer();
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
		return this.credit.accountsList;
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
		this.credit.writeData();
		return addWithdraw.getEntry();
	}

	@Override
	public Entry deposit(Account account, double amount) {
		AddDepositOperation addDeposit = new AddDepositOperation(account, amount);
		Ops.submit(addDeposit);
		this.credit.writeData();
		return addDeposit.getEntry();
	}
}
