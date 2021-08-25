package View;

import Config.ConstantValue;
import Service.EmployeeService;

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
            case "3":
                MainForm.menu();
                break;
        }
    }

    public static void mainMenu(){
        System.out.println("Welcome To Bank \n" +
                "SignUp Employee Press 1 \n" +
                "SignIn Employee Press 2 \n" +
                "Back To Menu Press 3 ");
    }
}
