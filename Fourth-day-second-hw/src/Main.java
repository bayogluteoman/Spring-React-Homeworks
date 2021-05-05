import Abstract.BaseCustomerManager;
import Concrete.CustomerCheckManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BaseCustomerManager baseCustomerManager = new StarbucksCustomerManager(new CustomerCheckManager());

        baseCustomerManager.save(new Customer(
                1,
                "Teoman",
                "Bayoğlu",
                new Date(1998, Calendar.JULY,15),
                "12345678910"));
    }
}
