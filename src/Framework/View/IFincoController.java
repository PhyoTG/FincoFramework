package Framework.View;

import java.util.Collection;

import Framework.Account.Account;
import Framework.Account.Entry;
import Framework.Customer.Customer;

public interface IFincoController {
//	void setVisible();
//
//    IFramework getFrameworkApplication();
//
//    void setFrameworkApplication(IFramework frameworkApplication);
//
    Customer addPersonAccount(String accountNum, String name, String street, String city, String state, Integer zip, String email, String birthDate, String acctype);

    Customer addCompanyAccount(String accountNum, String name, String street, String city, String state, Integer zip, String email, String noEmployees, String acctype);
    
    Customer addCreditAccount(String accountNum, String name, String street, String city, String state, Integer zip, String email, String noEmployees, String acctype);
    
    Account createAccount(Customer customer, String accountNum, String acctype);

    Collection<Account> getAccounts();

    void generateReport();

    void addInterest();

    Entry withdraw(Account account, double amount);

    Entry deposit(Account account, double amount);
}
