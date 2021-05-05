package Concrete;

import Abstract.ICustomerCheckService;
import Entities.Customer;

import java.util.Calendar;
import java.util.Date;

public class CustomerCheckManager implements ICustomerCheckService {

    @Override
    public boolean CheckIfRealPerson(Customer customer) {
        if(customer.getBirth_date().equals(new Date(1998, Calendar.JULY,15)) &&
                customer.getFirst_name().equals("Teoman") &&
                     customer.getLast_name().equals("Bayoğlu")&&
                         customer.getNationality_id()=="12345678910" &&
                              customer.getId()==1){
            return true;
        }
        else{
            return false;}
    }
}
