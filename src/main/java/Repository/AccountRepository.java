package Repository;

import Config.DBConnector;
import Entity.AccountEntity;

import javax.transaction.Transactional;
import java.util.List;

public class AccountRepository {
    public static List<AccountEntity> findCustomerAccount(String customerUserName) {
        List<AccountEntity> accountEntities = DBConnector.query("SELECT userAcc FROM AccountEntity userAcc WHERE userAcc.accountOwner = '" + customerUserName + "'");
        return accountEntities;
    }


    public static void setCreditCard(AccountEntity accountEntities) {
        DBConnector.update(accountEntities);
    }

    public static void save(AccountEntity newAccount) {
        DBConnector.save(newAccount);
    }
}
