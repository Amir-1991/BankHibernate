package Service;

import Config.ConstantValue;
import Config.Generator;
import Entity.AccountEntity;
import Entity.CreditCardEntity;
import Entity.CustomerEntity;
import Repository.AccountRepository;
import Repository.CreditCardRepository;
import View.CustomerForm;

import java.time.LocalDate;
import java.util.List;

public class CreditCardService {
    public static void requestCreditCard(List<CustomerEntity> resultCustomer) {
        CreditCardEntity creditCardEntity = new CreditCardEntity();
        List<AccountEntity> accountEntities = AccountRepository.findCustomerAccount(resultCustomer);
        if (accountEntities.get(0).getAccountCreditCard() == null) {
            if (resultCustomer.get(0).getId().equals(accountEntities.get(0).getAccountOwner().getId())) {
                creditCardEntity.setCreditCardNumber(Generator.createGenerateNumber(16));
                creditCardEntity.setAccountCvv2Number(Generator.createGenerateNumber(4));
                creditCardEntity.setCreditSalary(accountEntities.get(0).getAccountSalary());
                creditCardEntity.setCreditCardExpDate(LocalDate.from(LocalDate.now().plusYears(2)));
                CreditCardRepository.createCreditCard(creditCardEntity);
                System.out.println(ConstantValue.SUCCESS_REQUEST);
                AccountService.setCreditCard(accountEntities.get(0), creditCardEntity);
                CustomerForm.customerPanel(resultCustomer);
            } else {
                System.out.println(ConstantValue.UNSUCCESS_CREDIT_CARD);
                CustomerForm.customerPanel(resultCustomer);
            }
        }else{
            System.out.println(ConstantValue.HAVE_CREDIT);
        }
    }
}
