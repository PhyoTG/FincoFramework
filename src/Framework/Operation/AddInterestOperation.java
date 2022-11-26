package Framework.Operation;

import Framework.DataManager;
import Framework.Account.Account;

public class AddInterestOperation  implements Operation{
	
	DataManager finco;
	double interestRate = 0.07;
	
	public AddInterestOperation(DataManager finCo){
		this.finco = finCo;
	}

	@Override
	public void execute() {
		for (Account a : this.finco.accountsList) {
			a.setCurrentAmount(a.getCurrentAmount() + a.getCurrentAmount()*interestRate);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
