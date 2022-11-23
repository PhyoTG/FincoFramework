package Framework.Account;

import java.util.Date;

public class Entry {
	private Account account;
	private Double amount;
	private Date date;
	
	public Entry(Account account, double amount) {
        this.setAccount(account);
        this.setAmount(amount);
        this.setDate(new Date());
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
