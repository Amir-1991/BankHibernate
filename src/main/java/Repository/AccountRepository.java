package Repository;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.AccountEntity;
import Entity.CustomerEntity;
import View.CustomerForm;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public static List<AccountEntity> findCustomerAccount(List<CustomerEntity> resultCustomer) {
        List<AccountEntity> accountEntities = DBConnector.query("SELECT userAcc FROM AccountEntity userAcc WHERE userAcc.accountOwner = '" + resultCustomer.get(0).getId() + "'");
        return accountEntities;
    }


    public static void setCreditCard(AccountEntity accountEntities) {
        DBConnector.update(accountEntities);
    }

    public static List<AccountEntity> seeAllInformation(List<CustomerEntity> resultCustomer) {
        List<AccountEntity> resultAllInfo = new ArrayList<>();
        try {
            resultAllInfo = DBConnector.query("SELECT allAcc FROM AccountEntity allAcc WHERE allAcc.accountOwner = '" + resultCustomer.get(0).getId() + "'");
        } catch (Exception e) {
            System.out.println(ConstantValue.NOT_USER);
            CustomerForm.customerPanel(resultCustomer);
        }
        return resultAllInfo;
    }

    public static List<AccountEntity> showAllAccount(List<CustomerEntity> resultCustomer) {
        List<AccountEntity> allAccount = new ArrayList<>();
        try {
            allAccount = DBConnector.query(ConstantValue.ALL_ACCOUNT);
        }catch (Exception e){
            System.out.println(ConstantValue.UNSUCCESS_REQUEST);
            CustomerForm.customerPanel(resultCustomer);
        }
        return allAccount;
    }

    public static void save(AccountEntity newAccount) {
        DBConnector.save(newAccount);
    }

    public static void update(AccountEntity accountEntity) {
        DBConnector.update(accountEntity);
    }
}
