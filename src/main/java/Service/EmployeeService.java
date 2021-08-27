package Service;

import Config.ConstantValue;
import Entity.EmployeeEntity;
import Entity.RollEntity;
import Repository.EmployeeRepository;
import Repository.RollRepository;
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
        newEmployee.setEmployeeRollTitle(rolls.get(0).getRollTitle());
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

    public static void asSignRoll() {
        Scanner scanner = new Scanner(System.in);
        List<String> empRoll = new ArrayList<>();
        List<EmployeeEntity> empResult = showEmployees();
        String empId;
        System.out.println("Please Choice Employee Id Is Behind List \n" +
                " Id\t Employee UserName");
        for (int empCounter = 0; empCounter < empResult.size(); empCounter++) {
            System.out.println((empCounter + 1) + ": " + empResult.get(empCounter).getEmployeeUserName());
        }
        do {
            empId = scanner.next();
        } while (empId.matches(ConstantValue.MENU_REGEX));
        empRoll.add(0, String.valueOf(empResult.get((Integer.parseInt(empId) - 1)).getId()));
        List<RollEntity> rollResult = RollRepository.seeAllRolls();
        String rollId;
        System.out.println("Please Choice Roll Id Is Behind List \n" +
                " Id\t Roll Title");
        for (int rollCounter = 0; rollCounter < rollResult.size(); rollCounter++) {
            System.out.println((rollCounter + 1) + ": " + rollResult.get(rollCounter).getRollTitle());
        }
        do {
            rollId = scanner.next();
        } while (rollId.matches(ConstantValue.MENU_REGEX));
        empRoll.add(1, rollResult.get((Integer.parseInt(rollId) - 1)).getRollTitle());
        EmployeeRepository.setRollToEmployee(empRoll);
    }

    private static List showEmployees() {
        List<EmployeeEntity> empRes = EmployeeRepository.allEmployees();
        return empRes;
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
