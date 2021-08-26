package Repository;

import Config.DBConnector;
import Entity.EmployeeEntity;
import View.CustomerForm;

import java.util.List;

public class EmployeeRepository {
    public static void save(EmployeeEntity newEmployee) {
        try {
            DBConnector.save(newEmployee);
            DBConnector.commit();
        } catch (Exception e) {
            System.out.println("Your Information Already Has Is DB");
            CustomerForm.menu();
        }
    }

    public static List<EmployeeEntity> load(List<String> logInfo) {
        String query = "select emp from EmployeeEntity emp where emp.employeeUserName like " + logInfo.get(0) + "";
        List<EmployeeEntity> resultEmployee = DBConnector.query(query);
        return resultEmployee;
    }
}
