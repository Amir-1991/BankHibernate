package Service;

import Config.ConstantValue;
import Entity.CustomerEntity;
import Repository.CustomerRepository;
import View.CustomerForm;

import java.util.List;

public class CustomerService {
    public static void createCustomer() {
        CustomerEntity newCustomer = new CustomerEntity();
        String inputCustomer;
        showMessage(ConstantValue.USER_NAME);
        newCustomer.setCustomerUserName(ConstantValue.SCANNER.next());
        do {
            showMessage(ConstantValue.FIRST_NAME);
            inputCustomer = ConstantValue.SCANNER.next();
            newCustomer.setCustomerFirstName(inputCustomer);
        } while (!inputCustomer.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage(ConstantValue.LAST_NAME);
            inputCustomer = ConstantValue.SCANNER.next();
            newCustomer.setCustomerLastName(inputCustomer);
        } while (!inputCustomer.matches(ConstantValue.NAME_REGEX));
        do {
            showMessage(ConstantValue.NATIONAL_CODE);
            inputCustomer = ConstantValue.SCANNER.next();
            newCustomer.setCustomerNationalNumber(inputCustomer);
            newCustomer.setPassword(inputCustomer);
        } while (!inputCustomer.matches(ConstantValue.NATIONAL_CODE_REGEX));
        do {
            showMessage(ConstantValue.PHONE_NUMBER);
            inputCustomer = ConstantValue.SCANNER.next();
            newCustomer.setCustomerPhoneNumber(inputCustomer);
        } while (!inputCustomer.matches(ConstantValue.PHONE_NUMBER_REGEX));
        CustomerRepository.save(newCustomer);
        System.out.println(ConstantValue.SUCCESS_REQUEST);
        CustomerForm.menu();
    }

    public static void signInCustomer() {
        showMessage(ConstantValue.USER_NAME);
        ConstantValue.listString.add(0, ConstantValue.SCANNER.next());
        showMessage(ConstantValue.PASSWORD);
        ConstantValue.listString.add(1, ConstantValue.SCANNER.next());
        List<CustomerEntity> resultCustomer = CustomerRepository.load(ConstantValue.listString);
        if (resultCustomer.size() == 0) {
            System.out.println(ConstantValue.NOT_USER);
            CustomerForm.menu();
        } else if (!resultCustomer.get(0).getPassword().equals(ConstantValue.listString.get(1))) {
            System.out.println(ConstantValue.WRONG_PASSWORD);
            CustomerForm.menu();
        } else {
            CustomerForm.customerPanel(resultCustomer);
        }
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
