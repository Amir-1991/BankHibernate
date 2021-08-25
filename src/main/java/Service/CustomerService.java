package Service;

import Config.ConstantValue;
import Entity.CustomerEntity;
import Repository.CustomerRepository;
import View.CustomerForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    public static void createCustomer() {
        Scanner scanner = new Scanner(System.in);
        CustomerEntity newCustomer = new CustomerEntity();
        String inputCustomer;
        showMessage("User Name");
        newCustomer.setCustomerUserName(scanner.next());
        do {
            showMessage("First Name");
            inputCustomer = scanner.next();
            newCustomer.setCustomerFirstName(inputCustomer);
        }while (!inputCustomer.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage("Last Name");
            inputCustomer = scanner.next();
            newCustomer.setCustomerLastName(inputCustomer);
        }while (!inputCustomer.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage("National Code");
            inputCustomer = scanner.next();
            newCustomer.setCustomerNationalNumber(inputCustomer);
            newCustomer.setPassword(inputCustomer);
        }while (!inputCustomer.matches(ConstantValue.NATIONAL_CODE_REGEX));
        do {
            showMessage("Phone Number");
            inputCustomer = scanner.next();
            newCustomer.setCustomerPhoneNumber(inputCustomer);
        }while (!inputCustomer.matches(ConstantValue.PHONE_NUMBER_REGEX));
        CustomerRepository.save(newCustomer);
        System.out.println("Congratulations Your Panel Created ");
        CustomerForm.menu();
    }

    public static void signInCustomer() {
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showMessage("User Name");
        logInfo.add(0,logInScanner.next());
        showMessage("Password");
        logInfo.add(1,logInScanner.next());
        List<CustomerEntity> resultCustomer = CustomerRepository.load(logInfo);
        if (resultCustomer.size() == 0){
            System.out.println("User Not Found");
        }else if (!resultCustomer.get(0).getPassword().equals(logInfo.get(1))){
            System.out.println("Password Is Wrong ");
        }else{
            CustomerForm.customerPanel(resultCustomer);
        }
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
