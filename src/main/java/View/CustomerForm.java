package View;

import Config.ConstantValue;
import Entity.CreditCardEntity;
import Entity.CustomerEntity;
import Service.AccountService;
import Service.CreditCardService;
import Service.CustomerService;

import java.util.List;
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
            case "0":
                MainForm.menu();
                break;
        }
    }

    public static void customerPanel(List<CustomerEntity> resultCustomer) {
        Scanner scanner = new Scanner(System.in);
        String customerInput;
        customerMenu();
        do {
            customerInput =scanner.next();
        }while (!customerInput.matches(ConstantValue.MENU_REGEX));
        switch (customerInput){
            case "1":
                AccountService.createAccount();
                break;
            case "2":
                CreditCardService.createCreditCard();
                break;
            case "0":
                menu();
                break;
        }
    }

    public static void mainMenu(){
        System.out.println("Welcome To Bank \n" +
                "1: SignUp Customers \n" +
                "2: SignIn Customers \n" +
                "0: Back To Menu ");
    }

    public static void customerMenu(){
        System.out.println("This Is Your Panel \n" +
                "1: Creat Account \n" +
                "2: Creat Credit Card \n" +
                "0: Exit");
    }
}
