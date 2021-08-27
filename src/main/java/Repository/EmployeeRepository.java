package Repository;

import Config.DBConnector;
import Entity.EmployeeEntity;
import View.AdminForm;
import View.EmployeeForm;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public static void save(EmployeeEntity newEmployee) {
        try {
            DBConnector.save(newEmployee);
            DBConnector.commit();
        } catch (Exception e) {
            System.out.println("Your Information Already Has Is DB");
            EmployeeForm.menu();
        }
    }

    public static List<EmployeeEntity> load(List<String> logInfo) {
        List<EmployeeEntity> resultEmployee = new ArrayList<>();
        try {
            String query = "select emp from EmployeeEntity emp where emp.employeeUserName like " + logInfo.get(0) + "";
             resultEmployee= DBConnector.query(query);
        }catch (Exception e){
            System.out.println("Your Information Not Found In DB");
            EmployeeForm.menu();
        }
        return resultEmployee;
    }

    public static List allEmployees() {
        List<EmployeeEntity> empResult = new ArrayList<>();
        try {
            DBConnector.query("SELECT emps FROM EmployeeEntity emps ");
        }catch (Exception e){
            System.out.println("No Employee In Table");
            EmployeeForm.menu();
        }
        return empResult;
    }

    public static void setRollToEmployee(List<String> empRoll) {
        try {
            DBConnector.query("UPDATE EmployeeEntity empE SET empE.employeeRollTitle LIKE "+empRoll.get(1)+" WHERE empE.employeeUserName LIKE "+empRoll.get(0));
        }catch (Exception e){
            System.out.println("Sorry Cant Set Roll Please Try Again");
            EmployeeForm.menu();
        }
    }

    public static List allManagers() {
        List<EmployeeEntity> manageResult = new ArrayList<>();
        try {
            DBConnector.query("SELECT manage FROM EmployeeEntity manage WHERE manage.employeeRollTitle LIKE Branch Manager");
        }catch (Exception e){
            System.out.println("No Manager In Employees ");
            AdminForm.mainDashboard();
        }
        return manageResult;
    }

    public static List<EmployeeEntity> allDeActiveManagers() {
        List<EmployeeEntity> manageResult = new ArrayList<>();
        try {
            DBConnector.query("SELECT manage FROM EmployeeEntity manage WHERE manage.employeeRollTitle LIKE Branch Manager AND manage.bankBranch IS NULL ");
        }catch (Exception e){
            System.out.println("No Manager Without Branch ");
            AdminForm.mainDashboard();
        }
        return manageResult;
    }

    public static void setBranch(List<String> managerBranch) {
        try {
            DBConnector.query("UPDATE EmployeeEntity emp SET emp.bankEmployees LIKE "+managerBranch.get(1)+"WHERE emp.employeeUserName LIKE "+managerBranch.get(0));
        }catch (Exception e){
            System.out.println("Process Failed Try Later ");
            AdminForm.mainDashboard();
        }
    }
}
