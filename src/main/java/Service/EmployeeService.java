package Service;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.*;
import Repository.EmployeeRepository;
import Repository.RollRepository;
import View.AdminForm;
import View.EmployeeForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public static void createEmployee() {
        Scanner scanner = new Scanner(System.in);
        EmployeeEntity newEmployee = new EmployeeEntity();
        String inputEmployee;
        showMessage("User Name");
        newEmployee.setEmployeeUserName(scanner.next());
        do {
            showMessage("First Name");
            inputEmployee = scanner.next();
            newEmployee.setEmployeeFirstName(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage("Last Name");
            inputEmployee = scanner.next();
            newEmployee.setEmployeeLastName(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage("National Code");
            inputEmployee = scanner.next();
            newEmployee.setEmployeeNationalCode(inputEmployee);
            newEmployee.setEmployeePassword(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.NATIONAL_CODE_REGEX));
        do {
            showMessage("Phone Number");
            inputEmployee = scanner.next();
            newEmployee.setEmployeePhoneNumber(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.PHONE_NUMBER_REGEX));
        List<RollEntity> rolls = RollRepository.seeAllRolls();
        newEmployee.setEmployeeRole(rolls.get(0));
        EmployeeRepository.save(newEmployee);
        System.out.println("Congratulations Your Panel Created ");
        EmployeeForm.menu();
    }

    public static void signInEmployee() {
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showMessage("User Name");
        logInfo.add(0, logInScanner.next());
        showMessage("Password");
        logInfo.add(1, logInScanner.next());
        List<EmployeeEntity> resultEmployee = EmployeeRepository.load(logInfo);
        if (resultEmployee.size() == 0) {
            System.out.println("User Not Found");
        } else if (!resultEmployee.get(0).getEmployeePassword().equals(logInfo.get(1))) {
            System.out.println("Password Is Wrong ");
        } else {
            EmployeeForm.employeePanel(resultEmployee);
        }
    }

    public static void asSignRoll(List<AdminEntity> resultAdmin) {
        Scanner scanner = new Scanner(System.in);
        List<EmployeeEntity> empResult = showEmployees();
        int empId;
        System.out.println("Please Choice Employee Id Is Behind List \n" +
                " Id\t Employee UserName");
        for (int empCounter = 0; empCounter < empResult.size(); empCounter++) {
            System.out.println((empCounter + 1) + ": " + empResult.get(empCounter).getEmployeeUserName());
        }
        do {
            empId = scanner.nextInt();
        } while (String.valueOf(empId).matches(ConstantValue.MENU_REGEX));
        List<RollEntity> rollResult = RollRepository.seeAllRolls();
        int rollId;
        System.out.println("Please Choice Roll Id Is Behind List \n" +
                " Id\t Roll Title");
        for (int rollCounter = 0; rollCounter < rollResult.size(); rollCounter++) {
            System.out.println((rollCounter + 1) + ": " + rollResult.get(rollCounter).getRollTitle());
        }
        do {
            rollId = scanner.nextInt();
        } while (String.valueOf(rollId).matches(ConstantValue.MENU_REGEX));
        EmployeeRepository.setRollToEmployee((empResult.get((empId) - 1)), rollResult.get((rollId) - 1));
        AdminForm.adminPanel(resultAdmin);
    }

    private static List showEmployees() {
        List<EmployeeEntity> empRes = EmployeeRepository.allEmployees();
        return empRes;
    }

    public static void seeAll() {
        List<EmployeeEntity> allEmployee = EmployeeRepository.allEmployees();
        if (allEmployee.size() == 0) {
            System.out.println("Not Employee Found ");
        } else {
            System.out.println("Id\t\tEmployee Name\t\tBranch Name ");
            for (int empCounter = 0; empCounter < allEmployee.size(); empCounter++) {
                System.out.println((empCounter + 1) + "\t\t" + allEmployee.get(empCounter).getEmployeeFirstName() + ' ' +
                        allEmployee.get(empCounter).getEmployeeLastName() + "\t\t" + allEmployee.get(empCounter).getBankEmployees().getBankBranchName());
            }
        }
        EmployeeForm.employeeMenu();
    }

    public static void seeAllEmpByBranch(List<EmployeeEntity> resultEmployee) {
        List<EmployeeEntity> employeeList = EmployeeRepository.findMyEmployee(resultEmployee);
        System.out.println("Id\t\tFirst Name\t\tLast Name\t\tNationalCode");
        for (int empCounter = 0; empCounter < employeeList.size(); empCounter++) {
            System.out.println((empCounter + 1) + ": \t\t" + employeeList.get(empCounter).getEmployeeFirstName() + ' ' +
                    employeeList.get(empCounter).getEmployeeLastName() + "\t\t" + employeeList.get(empCounter).getEmployeeNationalCode());
        }
        EmployeeForm.employeeMenu();
    }

    public static void update(BankBranchEntity bankBranchEntities) {
        DBConnector.update(bankBranchEntities);
    }

    public static void updateEmp(AccountEntity accountEntity) {
        DBConnector.update(accountEntity);
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
