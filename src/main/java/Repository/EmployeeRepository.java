package Repository;

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
            System.out.println("Your Information Already Has Is DB");
            EmployeeForm.menu();
        }
    }

    public static List<EmployeeEntity> load(List<String> logInfo) {
        List<EmployeeEntity> resultEmployee = new ArrayList<>();
        try {
            String query = "SELECT emp FROM EmployeeEntity emp WHERE emp.employeeUserName = '" + logInfo.get(0) + "'";
            resultEmployee = DBConnector.query(query);
        } catch (Exception e) {
            System.out.println("Your Information Not Found In DB");
            EmployeeForm.menu();
        }
        return resultEmployee;
    }

    public static List allEmployees() {
        List<EmployeeEntity> empResult = new ArrayList<>();
        try {
            empResult = DBConnector.query("SELECT emp FROM EmployeeEntity emp");
        } catch (Exception e) {
            System.out.println("No Employee In Table Please LogIn Again");
            MainForm.menu();
        }
        return empResult;
    }

    public static void setRollToEmployee(EmployeeEntity empResult, RollEntity rollResult) {
        try {
            DBConnector.update(rollResult);
        } catch (Exception e) {
            System.out.println("Sorry Cant Set Roll Please Try Again");
            EmployeeForm.menu();
        }
    }

    public static List allManagers(List<AdminEntity> resultAdmin) {
        List<EmployeeEntity> manageResult = new ArrayList<>();
        try {
            DBConnector.query("SELECT manage FROM EmployeeEntity manage WHERE manage.employeeRollTitle = 'Branch Manager'");
        } catch (Exception e) {
            System.out.println("No Manager In Employees ");
            AdminForm.adminPanel(resultAdmin);
        }
        return manageResult;
    }

    public static List<EmployeeEntity> allDeActiveManagers() {
        List<EmployeeEntity> manageResult = new ArrayList<>();
        try {
            manageResult = DBConnector.query("SELECT manage FROM EmployeeEntity manage WHERE manage.employeeRollTitle LIKE Branch Manager AND manage.bankBranch IS NULL ");
        } catch (Exception e) {
            System.out.println("No Manager Without Branch ");
            AdminForm.mainDashboard();
        }
        return manageResult;
    }

    public static List<EmployeeEntity> findMyEmployee(List<EmployeeEntity> resultEmployee) {
        List<EmployeeEntity> employees = new ArrayList<>();
        try {
            employees = DBConnector.query("SELECT res FROM EmployeeEntity res WHERE res.bankEmployees = '" + resultEmployee.get(0).getBankEmployees().getId() + "'");
        } catch (Exception e) {
            System.out.println(" Employees Not Found ");
            EmployeeForm.employeePanel(resultEmployee);
        }
        return employees;
    }
}
