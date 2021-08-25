package Repository;

import Config.DBConnector;
import Entity.CustomerEntity;
import View.CustomerForm;

import java.util.List;

public class CustomerRepository {
    public static void save(CustomerEntity newCustomer) {
        try {
            DBConnector.save(newCustomer);
            DBConnector.commit();
        } catch (Exception e) {
            System.out.println("Your Information Already Has Is DB");
            CustomerForm.menu();
        }
    }

    public static List load(List<String> logInfo) {
        String loadQuery = "select cus from CustomerEntity cus where cus.customerUserName like " + logInfo.get(0) + "";
        List<CustomerEntity> resultCustomer = DBConnector.query(loadQuery);
        return resultCustomer;
    }
}
