package Repository;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.AdminEntity;
import Entity.EmployeeEntity;
import Entity.RollEntity;
import View.AdminForm;
import View.EmployeeForm;
import View.MainForm;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public static void save(EmployeeEntity newEmployee) {
        try {
            DBConnector.save(newEmployee);
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_UNIQUE);
            EmployeeForm.menu();
        }
    }

    public static List<EmployeeEntity> load(List<String> logInfo) {
        List<EmployeeEntity> resultEmployee = new ArrayList<>();
        try {
            String query = "SELECT emp FROM EmployeeEntity emp WHERE emp.employeeUserName = '" + logInfo.get(0) + "'";
            resultEmployee = DBConnector.query(query);
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_FOUND);
            EmployeeForm.menu();
        }
        return resultEmployee;
    }

    public static List allEmployees() {
        List<EmployeeEntity> empResult = new ArrayList<>();
        try {
            empResult = DBConnector.query(ConstantValue.ALL_EMPLOYEE);
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_FOUND);
            MainForm.menu();
        }
        return empResult;
    }

    public static void setRollToEmployee(EmployeeEntity empResult, RollEntity rollResult) {
        try {
            DBConnector.update(rollResult);
        } catch (Exception e) {
            System.out.println(ConstantValue.UNSUCCESS_REQUEST);
            EmployeeForm.menu();
        }
    }

    public static List allManagers(List<AdminEntity> resultAdmin) {
        List<EmployeeEntity> manageResult = new ArrayList<>();
        try {
            DBConnector.query(ConstantValue.FETCH_MANAGERS);
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_FOUND);
            AdminForm.adminPanel(resultAdmin);
        }
        return manageResult;
    }

    public static List<EmployeeEntity> allDeActiveManagers() {
        List<EmployeeEntity> manageResult = new ArrayList<>();
        try {
            manageResult = DBConnector.query(ConstantValue.FETCH_MANAGER_NON_ACTIVE);
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_FOUND);
            AdminForm.mainDashboard();
        }
        return manageResult;
    }

    public static List<EmployeeEntity> findMyEmployee(List<EmployeeEntity> resultEmployee) {
        List<EmployeeEntity> employees = new ArrayList<>();
        try {
            employees = DBConnector.query("SELECT res FROM EmployeeEntity res WHERE res.bankEmployees = '" + resultEmployee.get(0).getBankEmployees().getId() + "'");
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_FOUND);
            EmployeeForm.employeePanel(resultEmployee);
        }
        return employees;
    }
}
