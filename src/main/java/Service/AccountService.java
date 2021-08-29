package Service;

import Entity.CreditCardEntity;
import View.CustomerForm;
import Entity.AccountEntity;
import Entity.CustomerEntity;
import Entity.BankBranchEntity;
import Repository.AccountRepository;
import Repository.BankBranchRepository;

import java.util.List;
import java.util.Scanner;

public class AccountService {
    public static void createAccount(List<CustomerEntity> resultCustomer) {
        Scanner scanner = new Scanner(System.in);
        AccountEntity newAccount = new AccountEntity();
        int inputAccount;
        newAccount.setAccountOwner(resultCustomer.get(0));
        List<BankBranchEntity> branches = BankBranchRepository.allBranches();
        showMessage("Branch");
        for (int branchCounter = 0; branchCounter < branches.size(); branchCounter++) {
            System.out.println((branchCounter + 1) + ": " + branches.get(branchCounter).getBankBranchName());
        }
        inputAccount = scanner.nextInt();
        newAccount.setAccountBankBranch(branches.get(inputAccount - 1));
        AccountRepository.save(newAccount);
        System.out.println("Your Account Has Created ");
        CustomerForm.customerPanel(resultCustomer);
    }

    public static void setCreditCard(AccountEntity accountEntities, CreditCardEntity creditCardEntity) {
        accountEntities.setAccountCreditCard(creditCardEntity);
        AccountRepository.setCreditCard(accountEntities);
        EmployeeService.updateEmp(accountEntities);
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
