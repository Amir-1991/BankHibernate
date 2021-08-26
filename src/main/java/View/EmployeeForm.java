package View;

import Config.ConstantValue;
import Entity.EmployeeEntity;
import Service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeForm {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        String employeeInput;
        mainMenu();
        do {
            employeeInput =scanner.next();
        }while (!employeeInput.matches(ConstantValue.MENU_REGEX));
        switch (employeeInput){
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

    public static void mainMenu(){
        System.out.println("Welcome To Bank \n" +
                "1: SignUp Employee\n" +
                "2: SignIn Employee \n" +
                "3: Back To Menu ");
    }

    public static void employeePanel(List<EmployeeEntity> resultEmployee) {
    }
}
