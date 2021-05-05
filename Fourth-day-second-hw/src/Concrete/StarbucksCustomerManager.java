package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

    private ICustomerCheckService iCustomerCheckService;

    public StarbucksCustomerManager(ICustomerCheckService iCustomerCheckService){
        this.iCustomerCheckService=iCustomerCheckService;
    }

    @Override
    public void save(Customer customer) {
        if (iCustomerCheckService.CheckIfRealPerson(customer)){
            System.out.println(customer.getFirst_name()+" "+customer.getLast_name()+
                    " has successfully saved to database.");
        }
        else{
            System.out.println("Error");
        }
    }
}
