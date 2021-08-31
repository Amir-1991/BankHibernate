package Repository;

import Config.ConstantValue;
import Config.DBConnector;
import Entity.BankBranchEntity;
import Entity.EmployeeEntity;
import View.AdminForm;

import java.util.List;

public class BankBranchRepository {

    public static List seeBranchManager() {
        List<BankBranchEntity> branchManagers = DBConnector.query(ConstantValue.SEE_BRANCH);
        return branchManagers;
    }

    public static void save(BankBranchEntity newBankBranch) {
        DBConnector.save(newBankBranch);
    }

    public static List<BankBranchEntity> allBranchesNoneActive() {
        List<BankBranchEntity> allBank = DBConnector.query(ConstantValue.ALL_BRANCH_NON_ACTIVE);
        return allBank;
    }

    public static List<BankBranchEntity> allBranches() {
        List<BankBranchEntity> allBranch = DBConnector.query(ConstantValue.ALL_BRANCH);
        return allBranch;
    }

    public static void update(EmployeeEntity employeeEntity) {
        DBConnector.update(employeeEntity);
    }
}
