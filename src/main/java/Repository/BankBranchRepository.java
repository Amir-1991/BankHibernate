package Repository;

import Config.DBConnector;
import Entity.BankBranchEntity;
import Entity.EmployeeEntity;
import View.AdminForm;

import java.util.List;

public class BankBranchRepository {

    public static List seeBranchManager() {
        List<BankBranchEntity> branchManagers = DBConnector.query("SELECT manage.bankBranchAdmin FROM BankBranchEntity manage");
        return branchManagers;
    }

    public static void save(BankBranchEntity newBankBranch) {
        DBConnector.save(newBankBranch);
    }

    public static List<BankBranchEntity> allBranchesNoneActive() {
        List<BankBranchEntity> allBank = DBConnector.query("SELECT bank FROM BankBranchEntity bank WHERE bank.bankBranchAdmin IS NULL ");
        return allBank;
    }

    public static List<BankBranchEntity> allBranches() {
        List<BankBranchEntity> allBranch = DBConnector.query("SELECT bank FROM BankBranchEntity bank");
        return allBranch;
    }

    public static void update(EmployeeEntity employeeEntity) {
        DBConnector.update(employeeEntity);
    }
}
