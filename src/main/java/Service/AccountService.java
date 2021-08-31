package Service;

import Config.ConstantValue;
import Config.Generator;
import Entity.CreditCardEntity;
import View.CustomerForm;
import Entity.AccountEntity;
import Entity.CustomerEntity;
import Entity.BankBranchEntity;
import Repository.AccountRepository;
import Repository.BankBranchRepository;

import java.util.List;

public class AccountService {
    public static void createAccount(List<CustomerEntity> resultCustomer) {
        AccountEntity newAccount = new AccountEntity();
        int inputAccount;
        newAccount.setAccountOwner(resultCustomer.get(0));
        List<BankBranchEntity> branches = BankBranchRepository.allBranches();
        newAccount.setAccountNumber(Generator.createGenerateNumber(13));
        showMessage(ConstantValue.ACCOUNT_AMOUNT);
        newAccount.setAccountSalary(ConstantValue.SCANNER.next());
        showMessage(ConstantValue.BRANCH);
        System.out.println(ConstantValue.BRANCH_TITLE);
        for (int branchCounter = 0; branchCounter < branches.size(); branchCounter++) {
            System.out.println((branchCounter + 1) + ":\t\t" + branches.get(branchCounter).getBankBranchName());
        }
        inputAccount = ConstantValue.SCANNER.nextInt();
        newAccount.setAccountBankBranch(branches.get(inputAccount - 1));
        AccountRepository.save(newAccount);
        System.out.println(ConstantValue.SUCCESS_REQUEST);
        CustomerForm.customerPanel(resultCustomer);
    }

    public static void setCreditCard(AccountEntity accountEntities, CreditCardEntity creditCardEntity) {
        accountEntities.setAccountCreditCard(creditCardEntity);
        AccountRepository.setCreditCard(accountEntities);
        EmployeeService.updateEmp(accountEntities);
    }

    public static void seeAllInformation(List<CustomerEntity> resultCustomer) {
        List<AccountEntity> allInfo = AccountRepository.seeAllInformation(resultCustomer);
        System.out.println(ConstantValue.CUSTOMER_TITLE);
        System.out.println(allInfo.get(0).getAccountOwner().getCustomerUserName()+"\t\t\t"+
                allInfo.get(0).getAccountOwner().getCustomerFirstName()+"  \t\t  "+
                allInfo.get(0).getAccountOwner().getCustomerLastName()+"   \t\t  "+
                allInfo.get(0).getAccountOwner().getCustomerNationalNumber()+" \t\t "+
                allInfo.get(0).getAccountNumber()+"\t\t "+allInfo.get(0).getAccountCreditCard().getCreditCardNumber()+"\t\t\t"+
                allInfo.get(0).getAccountCreditCard().getAccountCvv2Number()+"\t\t"+allInfo.get(0).getAccountSalary());
        CustomerForm.customerPanel(resultCustomer);
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }

    public static List<AccountEntity> showAllAccount(List<CustomerEntity> resultCustomer) {
        List<AccountEntity> allAccount = AccountRepository.showAllAccount(resultCustomer);
        return allAccount;
    }
}
