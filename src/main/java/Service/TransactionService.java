package Service;

import Config.ConstantValue;
import Entity.AccountEntity;
import Entity.CustomerEntity;
import Entity.TransactionEntity;
import Repository.AccountRepository;
import Repository.TransactionRepository;
import View.CustomerForm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    public static void createRequest(List<CustomerEntity> resultCustomer) {
        List<AccountEntity> existingAccount = AccountService.showAllAccount(resultCustomer);
        List<String> transferValues = new ArrayList<>();
        TransactionEntity newTransaction = new TransactionEntity();
        newTransaction.setOriginCard(resultCustomer.get(0).getAccountOwner().get(0).getAccountCreditCard());
        int input = 0;
        System.out.println(ConstantValue.REQUEST_AMOUNT);
        transferValues.add(0, ConstantValue.SCANNER.next());
        System.out.println(ConstantValue.REQUEST_CVV2);
        input = ConstantValue.SCANNER.nextInt();
        if (resultCustomer.get(0).getAccountOwner().get(0).getAccountCreditCard().getAccountCvv2Number().equals(String.valueOf(input))) {
            transferValues.add(1, resultCustomer.get(0).getAccountOwner().get(0).getAccountSalary());
            newTransaction.setTransferFee(transferValues.get(0));
            BigInteger validationValue = new BigInteger(transferValues.get(0));
            BigInteger currentValue = new BigInteger(transferValues.get(1));
            int afterTransaction = currentValue.compareTo(validationValue.add(ConstantValue.TRANSFER_FEE));
            if (afterTransaction == -1) {
                System.out.println(ConstantValue.NOT_ENOUGH_MONEY);
                CustomerForm.customerPanel(resultCustomer);
            } else {
                if (existingAccount.size() == 1) {
                    System.out.println(ConstantValue.NOT_ACCOUNT_FOUND);
                    CustomerForm.customerPanel(resultCustomer);
                } else {
                    System.out.println(ConstantValue.DESTINATION_MESSAGE);
                    System.out.println(ConstantValue.DESTINATION_CARD_INFO);
                    for (int accCounter = 0; accCounter < existingAccount.size(); accCounter++) {
                        if (!existingAccount.get(accCounter).getAccountOwner().getId().equals(resultCustomer.get(0).getId())) {
                            System.out.println((accCounter + 1) + "  \t\t  " + existingAccount.get(accCounter).getAccountOwner().getCustomerFirstName() + " \t\t\t "
                                    + existingAccount.get(accCounter).getAccountOwner().getCustomerLastName() + "\t\t\t " + existingAccount.get(0).getAccountOwner().getCustomerNationalNumber() + "\t\t\t"
                                    + existingAccount.get(accCounter).getAccountNumber() + "\t\t" + existingAccount.get(accCounter).getAccountCreditCard().getCreditCardNumber() + "\t\t"
                                    + existingAccount.get(accCounter).getAccountBankBranch().getBankBranchName());
                        }
                    }
                    String inputScanner = ConstantValue.SCANNER.next();
                    if (inputScanner.length() > 2) {
                        transferValues.add(2, inputScanner);
                    } else {
                        input = (int) Math.round(Double.parseDouble(inputScanner));
                    }
                    newTransaction.setDestinationCard(existingAccount.get(input - 1).getAccountCreditCard().
                            getCreditCardAccount().getAccountCreditCard());
                    if (inputScanner.length() <= 2) {
                        transferById(existingAccount, resultCustomer, input, transferValues, validationValue, currentValue);
                    } else if (inputScanner.length() == 13) {
                        transferByAccountNumber(existingAccount, resultCustomer, transferValues);
                    } else if (inputScanner.length() == 16) {
                        transferByCreditCard(existingAccount, resultCustomer, transferValues);
                    } else {
                        System.out.println(ConstantValue.NOT_VALID_INPUT);
                        CustomerForm.customerPanel(resultCustomer);
                    }
                    TransactionRepository.saveTransfer(newTransaction);
                    CustomerForm.customerPanel(resultCustomer);
                }
            }
        } else {
            System.out.println(ConstantValue.WRONG_CVV2);
            CustomerForm.customerPanel(resultCustomer);
        }
    }

    private static void transferById(List<AccountEntity> existingAccount, List<CustomerEntity> resultCustomer, int input, List<String> transferValues, BigInteger validationValue, BigInteger currentValue) {
        BigInteger amountDes = new BigInteger(transferValues.get(0));
        BigInteger currentValueDes = new BigInteger(existingAccount.get(input - 1).getAccountSalary());
        resultCustomer.get(0).getAccountOwner().get(0).setAccountSalary(String.valueOf(currentValue.subtract(amountDes.add(ConstantValue.TRANSFER_FEE))));
        existingAccount.get(input - 1).setAccountSalary(String.valueOf(currentValueDes.add(amountDes)));
        AccountRepository.update(resultCustomer.get(0).getAccountOwner().get(0));
        AccountRepository.update(existingAccount.get(input - 1));
    }

    private static void transferByAccountNumber(List<AccountEntity> existingAccount, List<CustomerEntity> resultCustomer, List<String> transferValues) {
    }

    private static void transferByCreditCard(List<AccountEntity> existingAccount, List<CustomerEntity> resultCustomer, List<String> transferValues) {

    }
}
