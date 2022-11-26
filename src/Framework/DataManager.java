

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

public class DataManager {
	public Collection<Account> accountsList = new ArrayList<>();
    public Collection<Customer> customersList = new ArrayList<>();
    public IDatabase db = new Database();
    
    public DataManager() {
		//loadData();
	}

	public void loadData() {
		JSONObject jsonObj = this.db.read("");
		JSONArray arr = (JSONArray) jsonObj.get("customers");
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

			this.customersList.add(customer);
			JSONArray accList = (JSONArray) obj.get("accounts");
			for (int j = 0; j < accList.size(); j++) {
				JSONObject obj1 = (JSONObject) accList.get(i);

	            Account a = new Account(
	                (String) obj1.get("accountNum"),
	                customer,
	                (String) obj1.get("acctype")
	            );			

				a.setCurrentAmount(Double.parseDouble(obj1.get("currentBalance").toString()));
				customer.addAccount(a);
				
				this.accountsList.add(a);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void writeData() {
		JSONObject jsonObj = new JSONObject();
		JSONArray customerList = new JSONArray();

		for (Customer customer : this.customersList) {
			JSONObject cust = new JSONObject();
			JSONArray accs = new JSONArray();

			cust.put("name", customer.getName());
			cust.put("city", customer.getCity());
			cust.put("email", customer.getEmail());
			cust.put("state", customer.getState());
			cust.put("street", customer.getStreet());
			cust.put("zip", customer.getZip());
			
			if(customer.getClass().equals(Company.class))
					cust.put("type", "company");
			else if(customer.getClass().equals(Person.class))
				cust.put("type", "person");

			for (Account a : this.accountsList) {
				JSONObject acc = new JSONObject();
				JSONArray entries = new JSONArray();

				acc.put("accountNum", a.getAccountNumber());
				acc.put("currentBalance", a.getCurrentAmount());

				for (Entry e : a.getEntryList()) {
					JSONObject entry = new JSONObject();

					entry.put("amount", e.getAmount());
					entry.put("date", e.getDate().toString());
					entries.add(entry);
				}

				acc.put("entries", entries);
				accs.add(a);
			}

			cust.put("accounts", accs);
			customerList.add(cust);
		}

		jsonObj.put("customers", customerList);

		this.db.write("", jsonObj);
	}
}
