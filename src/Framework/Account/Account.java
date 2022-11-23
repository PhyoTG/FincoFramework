package Framework.Account;

import java.util.ArrayList;
import java.util.List;

import Framework.Customer.Customer;

public class Account {
	private double currentAmount = 0;
	private String accountNumber;
	private String accType;
	private Customer cust;
	private List<Entry> entryList = new ArrayList<Entry>();
	
	public Account(String num, Customer customer, String acctype) {
		this.accountNumber = num;
		this.cust = customer;
		this.accType = acctype;
		this.currentAmount = 0;
	}
	
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double d) {
		this.currentAmount = d;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public List<Entry> getEntryList() {
		return entryList;
	}
	public void setEntryList(List<Entry> entryList) {
		this.entryList = entryList;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}
	
}
