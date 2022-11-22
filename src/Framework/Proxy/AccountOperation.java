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
		case "AddInterest":
			
			break;
		case "AddEntry":
			
			break;
		case "GetCurrentBalance":
			
			break;
		case "GenerateReport":
			
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
