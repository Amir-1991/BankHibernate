package View;

import Config.ConstantValue;
import Entity.EmployeeEntity;
import Service.EmployeeService;

import java.util.List;

public class EmployeeForm {
    public static void menu() {
        String employeeInput;
        mainMenu();
        do {
            employeeInput = ConstantValue.SCANNER.next();
        } while (!employeeInput.matches(ConstantValue.MENU_REGEX));
        switch (employeeInput) {
            case "1":
                EmployeeService.createEmployee();
                break;
            case "2":
                EmployeeService.signInEmployee();
                break;
            case "0":
                MainForm.menu();
                break;
        }
    }

    public static void employeePanel(List<EmployeeEntity> resultEmployee) {
        String employeeInput;
        employeeMenu();
        do {
            employeeInput = ConstantValue.SCANNER.next();
        } while (!employeeInput.matches(ConstantValue.MENU_REGEX));
        switch (employeeInput) {
            case "1":
                EmployeeService.seeAll();
                break;
            case "2":
                EmployeeService.seeAllEmpByBranch(resultEmployee);
                break;
            case "0":
                MainForm.menu();
                break;
        }
    }

    public static void employeeMenu() {
        System.out.println("Welcome To Bank \n" +
                "1: See All Employee\n" +
                "2: See Branch Employee \n" +
                "2: See Branch Employee \n" +
                "0: Back To Menu ");
    }

    public static void mainMenu() {
        System.out.println("Welcome To Bank \n" +
                "1: SignUp Employee\n" +
                "2: SignIn Employee \n" +
                "0: Back To Menu ");
    }
}
