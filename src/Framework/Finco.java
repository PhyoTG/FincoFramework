package Framework;

import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Company;
import Framework.Customer.Customer;
import Framework.Customer.Person;
import Framework.DB.Database;
import Framework.DB.IDatabase;

public class Finco {
	public Collection<Account> accounts = new ArrayList<>();
    public Collection<Customer> customers = new ArrayList<>();
    public IDatabase db = new Database();
    
    private void finco() {
		loadData();
	}

	private void loadData() {
		
	}
	
	@SuppressWarnings("unchecked")
	public void writeData() {
		JSONObject jsonObject = new JSONObject();
		JSONArray customers = new JSONArray();

		for (Customer customer : this.customers) {
			JSONObject c = new JSONObject();
			JSONArray accs = new JSONArray();

			c.put("name", customer.getName());
			c.put("city", customer.getCity());
			c.put("email", customer.getEmail());
			c.put("state", customer.getState());
			c.put("street", customer.getStreet());
			c.put("zip", customer.getZip());
			
			if(customer.getClass().equals(Company.class))
					c.put("type", "company");
			else if(customer.getClass().equals(Person.class))
				c.put("type", "person");

			for (Account account : this.accounts) {
				JSONObject a = new JSONObject();
				JSONArray entries = new JSONArray();

				a.put("accountNum", account.getAccountNumber());
				a.put("currentBalance", account.getCurrentAmount());

//				for (Entry entry : account.getEntryList()) {
//					JSONObject e = new JSONObject();
//
//					e.put("amount", entry.getAmount());
//					e.put("date", entry.getDate().toString());
//					if (entry instanceof DepositEntry) {
//						e.put("type", "deposit");
//					} else {
//						e.put("type", "withdraw");
//					}
//
//					entries.add(e);
//				}

				a.put("entries", entries);
				accs.add(a);
			}

			c.put("accounts", accs);
			customers.add(c);
		}

		jsonObject.put("customers", customers);

		this.db.write("", jsonObject);
	}
}
