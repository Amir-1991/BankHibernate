package Repository;

import Config.DBConnector;
import Entity.CreditCardEntity;

public class CreditCardRepository {
    public static void createCreditCard(CreditCardEntity creditCardEntity) {
        DBConnector.save(creditCardEntity);
    }
}
