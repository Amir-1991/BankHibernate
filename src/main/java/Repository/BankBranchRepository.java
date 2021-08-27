package Repository;

import Config.DBConnector;
import Entity.BankBranchEntity;
import View.AdminForm;

import java.util.List;

public class BankBranchRepository {

    public static List seeBranchManager() {
        List<BankBranchEntity> branchManagers = DBConnector.query("SELECT manage.bankBranchAdmin FROM BankBranchEntity manage");
        return branchManagers;
    }

    public static void save(BankBranchEntity newBankBranch) {
        DBConnector.save(newBankBranch);
        DBConnector.commit();
    }

    public static List<BankBranchEntity> allBranches() {
        List<BankBranchEntity> allBank = DBConnector.query("SELECT bank FROM BankBranchEntity bank WHERE bank.bankBranchAdmin IS NULL ");
        return allBank;
    }

    public static void setManager(List<String> managerBranch) {
        try {
            DBConnector.query("UPDATE BankBranchEntity bank SET bank.bankBranchName LIKE "+managerBranch.get(0)+"WHERE bank.bankBranchAdmin LIKE "+managerBranch.get(1));
        }catch (Exception e){
            System.out.println("Process Failed Try Later ");
            AdminForm.mainDashboard();
        }
    }
}
