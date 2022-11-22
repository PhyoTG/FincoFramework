package Framework.Proxy;

import Framework.Interface.AccountService;

public class AccountOperation implements AccountService{

	@Override
	public void doAction(String action) {
		switch (action) {
		case "Deposit":
			
			break;
		case "Withdrawl":
			
			break;
		default:
			break;
		}
	}
	
	public void deposit(int amount) {
		
	}
	
	public void withdrawl(int amount) {
		
	}

	
}
