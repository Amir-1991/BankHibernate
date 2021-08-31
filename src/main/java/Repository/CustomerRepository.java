package Repository;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.CustomerEntity;
import View.CustomerForm;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public static void save(CustomerEntity newCustomer) {
        try {
            DBConnector.save(newCustomer);
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_UNIQUE);
            CustomerForm.menu();
        }
    }

    public static List load(List<String> logInfo) {
        List<CustomerEntity> resultCustomer = new ArrayList<>();
        try {
            String query = "SELECT cus FROM CustomerEntity cus WHERE cus.customerUserName = '" + logInfo.get(0) + "'";
            resultCustomer = DBConnector.query(query);
        } catch (Exception e) {
            System.out.println(ConstantValue.UNSUCCESS_REQUEST);
            CustomerForm.menu();
        }
        return resultCustomer;
    }

    public static void update(CustomerEntity resultCustomer) {
        DBConnector.update(resultCustomer);
    }
}
