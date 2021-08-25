package View;

import Config.ConstantValue;
import Service.CustomerService;

import java.util.Scanner;

public class CustomerForm {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        String customerInput;
        mainMenu();
        do {
            customerInput =scanner.next();
        }while (!customerInput.matches(ConstantValue.MENU_REGEX));
        switch (customerInput){
            case "1":
                CustomerService.createCustomer();
                break;
            case "2":
                CustomerService.signInCustomer();
                break;
            case "3":
                MainForm.menu();
                break;
        }
    }

    public static void mainMenu(){
        System.out.println("Welcome To Bank \n" +
                "SignUp Customers Press 1 \n" +
                "SignIn Customers Press 2 \n" +
                "Back To Menu Press 3 ");
    }
}
