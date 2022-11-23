package Framework.Operation;

import javax.swing.JOptionPane;

import Framework.Account.Account;
import Framework.Account.Entry;

public class AddWithdrawOperation implements Operation{
	
	private static javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	private Account accNo;
    private Double amount;
    private Entry entry;
    
    public AddWithdrawOperation(Account accNo, double amount){
		this.accNo = accNo;
		this.amount = amount;
		
		}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		setEntry(new Entry(accNo, amount));
		double newamt = accNo.getCurrentAmount() - amount;
		accNo.setCurrentAmount(accNo.getCurrentAmount() - amount);
		if (newamt <0){
		       JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accNo.getAccountNumber()+" : balance is negative: $"+newamt+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    }
		System.out.println("withdraw...." + this.entry.getAmount());
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
