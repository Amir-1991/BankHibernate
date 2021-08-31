package View;

import Config.ConstantValue;
import Service.AdminService;

public class MainForm {

    public static void menu() {
        String menuInput;
        mainMenu();
        do {
            menuInput = ConstantValue.SCANNER.next();
        }while (!menuInput.matches(ConstantValue.MENU_REGEX));
        switch (menuInput){
            case "1":
                CustomerForm.menu();
                break;
            case "2":
                EmployeeForm.menu();
                break;
            case "3":
                System.out.println(ConstantValue.END);
                break;
            case "0":
                AdminService.signInAdmin();
                break;
        }
    }

    public static void mainMenu(){
        System.out.println("Welcome To Bank \n" +
                "1: Customers \n" +
                "2: Employees \n" +
                "3: Exit ");
    }
}
