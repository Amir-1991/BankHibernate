package Repository;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.TransactionEntity;
import View.CustomerForm;

public class TransactionRepository {

    public static void saveTransfer(TransactionEntity newTransaction) {
        try {
            DBConnector.save(newTransaction);
        }catch (Exception e){
            System.out.println(ConstantValue.UNSUCCESS_REQUEST);
            CustomerForm.menu();
        }
    }
}
