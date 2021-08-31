package Service;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.*;
import Repository.EmployeeRepository;
import Repository.RollRepository;
import View.AdminForm;
import View.EmployeeForm;

import java.util.List;

public class EmployeeService {
    public static void createEmployee() {
        EmployeeEntity newEmployee = new EmployeeEntity();
        String inputEmployee;
        showMessage(ConstantValue.USER_NAME);
        newEmployee.setEmployeeUserName(ConstantValue.SCANNER.next());
        do {
            showMessage(ConstantValue.FIRST_NAME);
            inputEmployee = ConstantValue.SCANNER.next();
            newEmployee.setEmployeeFirstName(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage(ConstantValue.LAST_NAME);
            inputEmployee = ConstantValue.SCANNER.next();
            newEmployee.setEmployeeLastName(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage(ConstantValue.NATIONAL_CODE);
            inputEmployee = ConstantValue.SCANNER.next();
            newEmployee.setEmployeeNationalCode(inputEmployee);
            newEmployee.setEmployeePassword(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.NATIONAL_CODE_REGEX));
        do {
            showMessage(ConstantValue.PHONE_NUMBER);
            inputEmployee = ConstantValue.SCANNER.next();
            newEmployee.setEmployeePhoneNumber(inputEmployee);
        } while (!inputEmployee.matches(ConstantValue.PHONE_NUMBER_REGEX));
        List<RollEntity> rolls = RollRepository.seeAllRolls();
        newEmployee.setEmployeeRole(rolls.get(0));
        EmployeeRepository.save(newEmployee);
        System.out.println(ConstantValue.SUCCESS_REQUEST);
        EmployeeForm.menu();
    }

    public static void signInEmployee() {
        showMessage(ConstantValue.USER_NAME);
        ConstantValue.listString.add(0, ConstantValue.SCANNER.next());
        showMessage(ConstantValue.PASSWORD);
        ConstantValue.listString.add(1, ConstantValue.SCANNER.next());
        List<EmployeeEntity> resultEmployee = EmployeeRepository.load(ConstantValue.listString);
        if (resultEmployee.size() == 0) {
            System.out.println(ConstantValue.NOT_USER);
        } else if (!resultEmployee.get(0).getEmployeePassword().equals(ConstantValue.listString.get(1))) {
            System.out.println(ConstantValue.WRONG_PASSWORD);
        } else {
            EmployeeForm.employeePanel(resultEmployee);
        }
    }

    public static void asSignRoll(List<AdminEntity> resultAdmin) {
        List<EmployeeEntity> empResult = showEmployees();
        int empId;
        System.out.println(ConstantValue.CHOICE_EMPLOYEE);
        for (int empCounter = 0; empCounter < empResult.size(); empCounter++) {
            System.out.println((empCounter + 1) + ": " + empResult.get(empCounter).getEmployeeUserName());
        }
        do {
            empId = ConstantValue.SCANNER.nextInt();
        } while (String.valueOf(empId).matches(ConstantValue.MENU_REGEX));
        List<RollEntity> rollResult = RollRepository.seeAllRolls();
        int rollId;
        System.out.println(ConstantValue.CHOICE_ROLL);
        for (int rollCounter = 0; rollCounter < rollResult.size(); rollCounter++) {
            System.out.println((rollCounter + 1) + ": " + rollResult.get(rollCounter).getRollTitle());
        }
        do {
            rollId = ConstantValue.SCANNER.nextInt();
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
            System.out.println(ConstantValue.NOT_EMPLOYEE);
        } else {
            System.out.println(ConstantValue.EMPLOYEE_TITLE);
            for (int empCounter = 0; empCounter < allEmployee.size(); empCounter++) {
                System.out.println((empCounter + 1) + "\t\t" + allEmployee.get(empCounter).getEmployeeFirstName() + ' ' +
                        allEmployee.get(empCounter).getEmployeeLastName() + "\t\t" + allEmployee.get(empCounter).getBankEmployees().getBankBranchName());
            }
        }
        EmployeeForm.employeeMenu();
    }

    public static void seeAllEmpByBranch(List<EmployeeEntity> resultEmployee) {
        List<EmployeeEntity> employeeList = EmployeeRepository.findMyEmployee(resultEmployee);
        System.out.println(ConstantValue.EMPLOYEE_INFORMATION);
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
