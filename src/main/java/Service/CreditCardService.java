package Service;

import Entity.AccountEntity;
import Entity.CreditCardEntity;
import Entity.CustomerEntity;
import Repository.AccountRepository;
import Repository.CreditCardRepository;
import View.CustomerForm;

import java.util.List;
import java.util.Random;

public class CreditCardService {
    public static void requestCreditCard(List<CustomerEntity> resultCustomer) {
        Long customerUserId = resultCustomer.get(0).getId();
        CreditCardEntity creditCardEntity = new CreditCardEntity();
        List<AccountEntity> accountEntities = AccountRepository.findCustomerAccount(String.valueOf(customerUserId));
        Random idInput = new Random();
        int randomID;
        if (resultCustomer.get(0).getId().equals(accountEntities.get(0).getAccountOwner().getId())){
            randomID = idInput.nextInt( 60370000 + 1);
            creditCardEntity.setCreditCardNumber(randomID);
            CreditCardRepository.createCreditCard(creditCardEntity);
            System.out.println("Your Request Is Success Done ");
            AccountService.setCreditCard(accountEntities.get(0),creditCardEntity);
            CustomerForm.customerPanel(resultCustomer);
        }else {
            System.out.println("Your Request Failed If You Haven't Credit Card Please Try Later");
            CustomerForm.customerPanel(resultCustomer);
        }
    }
}
