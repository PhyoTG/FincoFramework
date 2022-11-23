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
    
    public Finco() {
		//loadData();
	}

	public void loadData() {
		JSONObject jsonObject = this.db.read("");
		JSONArray arr = (JSONArray) jsonObject.get("customers");
		for (int i = 0; i < arr.size(); i++) {
			JSONObject obj = (JSONObject) arr.get(i);
			Customer customer;

			if (obj.get("type").equals("company")) {
				customer = new Company((String) obj.get("name"),
									   (String) obj.get("street"),
									   (String) obj.get("city"),
									   (String) obj.get("state"),
									   Integer.parseInt(obj.get("zip").toString()),
									   (String) obj.get("email"),
									   (String) obj.get("noEmployees"));
			} else {
				customer = new Person((String) obj.get("name"),
									  (String) obj.get("street"),
									  (String) obj.get("city"),
									  (String) obj.get("state"),
									  Integer.parseInt(obj.get("zip").toString()),
									  (String) obj.get("email"),
									  (String) obj.get("birthDate"));
			}

			this.customers.add(customer);
			JSONArray accList = (JSONArray) obj.get("accounts");
			for (int j = 0; j < accList.size(); j++) {
				JSONObject o = (JSONObject) accList.get(i);

	            Account a = new Account(
	                (String) o.get("accountNum"),
	                customer,
	                (String) o.get("acctype")
	            );			

				a.setCurrentAmount(Double.parseDouble(o.get("currentBalance").toString()));
				customer.addAccount(a);
				
				this.accounts.add(a);
			}
		}
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

				for (Entry entry : account.getEntryList()) {
					JSONObject e = new JSONObject();

					e.put("amount", entry.getAmount());
					e.put("date", entry.getDate().toString());
					entries.add(e);
				}

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
