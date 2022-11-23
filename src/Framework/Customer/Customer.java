package Framework.Customer;

import java.util.ArrayList;
import java.util.Collection;

import Framework.Account.Account;

public class Customer {
	private String name;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String email;
    private Collection<Account> accountList = new ArrayList<>();
    
    public Customer(String name, String street, String city, String state, Integer zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void addAccount(Account account) {
		accountList.add(account);
	}

	public Collection<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(Collection<Account> accountList) {
		this.accountList = accountList;
	}
}
