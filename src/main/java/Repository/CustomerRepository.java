package Repository;

import Config.DBConnector;
import Entity.CustomerEntity;
import View.CustomerForm;

import java.util.List;

public class CustomerRepository {
    public static void save(CustomerEntity newCustomer) {
        try {
            DBConnector.save(newCustomer);
        } catch (Exception e) {
            System.out.println("Your Information Already Has Is DB");
            CustomerForm.menu();
        }
    }

    public static List load(List<String> logInfo) {
        String query = "SELECT cus FROM CustomerEntity cus WHERE cus.customerUserName = '" + logInfo.get(0) + "'";
        List<CustomerEntity> resultCustomer = DBConnector.query(query);
        return resultCustomer;
    }
}
