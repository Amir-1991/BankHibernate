package Service;

import Config.ConstantValue;
import Entity.CustomerEntity;
import Entity.EmployeeEntity;
import Repository.CustomerRepository;
import Repository.EmployeeRepository;
import View.CustomerForm;
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
        }while (!inputEmployee.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage("Last Name");
            inputEmployee = scanner.next();
            newEmployee.setEmployeeLastName(inputEmployee);
        }while (!inputEmployee.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage("National Code");
            inputEmployee = scanner.next();
            newEmployee.setEmployeeNationalCode(inputEmployee);
            newEmployee.setEmployeePassword(inputEmployee);
        }while (!inputEmployee.matches(ConstantValue.NATIONAL_CODE_REGEX));
        do {
            showMessage("Phone Number");
            inputEmployee = scanner.next();
            newEmployee.setEmployeePhoneNumber(inputEmployee);
        }while (!inputEmployee.matches(ConstantValue.PHONE_NUMBER_REGEX));
        EmployeeRepository.save(newEmployee);
        System.out.println("Congratulations Your Panel Created ");
        EmployeeForm.menu();
    }

    public static void signInEmployee() {
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showMessage("User Name");
        logInfo.add(0,logInScanner.next());
        showMessage("Password");
        logInfo.add(1,logInScanner.next());
        List<EmployeeEntity> resultEmployee = EmployeeRepository.load(logInfo);
        if (resultEmployee.size() == 0){
            System.out.println("User Not Found");
        }else if (!resultEmployee.get(0).getEmployeePassword().equals(logInfo.get(1))){
            System.out.println("Password Is Wrong ");
        }else{
            EmployeeForm.employeePanel(resultEmployee);
        }
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
