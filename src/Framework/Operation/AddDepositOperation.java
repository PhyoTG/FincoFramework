package Framework.Operation;

import Framework.Finco;
import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Customer;
import Framework.Customer.Person;

public class AddDepositOperation implements Operation{
	
	private Account accNo;
    private double amount;
    private Entry entry;
    
    public AddDepositOperation(Account accNo, double amount){
			this.accNo = accNo;
			this.amount = amount;
			
			}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		setEntry(new Entry(accNo, amount));
		System.out.println("deposit...." + this.entry.getAmount());
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
	
	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	
}
