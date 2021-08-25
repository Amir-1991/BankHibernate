package View;

import Config.ConstantValue;

import java.util.Scanner;

public class MainForm {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        String menuInput;
        mainMenu();
        do {
            menuInput = scanner.next();
        }while (!menuInput.matches(ConstantValue.MENU_REGEX));
        switch (menuInput){
            case "1":
                CustomerForm.menu();
                break;
            case "2":
                EmployeeForm.menu();
                break;
            case "3":
                System.out.println("GoodLuck");
                break;
        }
    }

    public static void mainMenu(){
        System.out.println("Welcome To Bank \n" +
                "Customers Press 1 \n" +
                "Employees Press 2 \n" +
                "Exit Press 3 ");
    }
}
