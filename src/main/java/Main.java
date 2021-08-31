import Config.DBConnector;
import Entity.AdminEntity;
import Entity.BankBranchEntity;
import Entity.RollEntity;
import View.MainForm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBConnector.connection();
        creatAdmin();
        createDefineRolls();
        creatCentralBranch();
        MainForm.menu();
        DBConnector.disConnection();
    }

    public static void creatAdmin() {
        List adminCount = DBConnector.query("SELECT admin FROM AdminEntity admin");
        if (adminCount.size() == 0) {
            AdminEntity admin = new AdminEntity();
            admin.setAdminName("admin");
            admin.setAdminPassword("admin");
            DBConnector.save(admin);
        }

    }

    private static void createDefineRolls() {
        List rollCount = DBConnector.query("SELECT roll FROM RollEntity roll");
        if (rollCount.size() == 0) {
            RollEntity rollEmployee = new RollEntity();
            rollEmployee.setRollTitle("Simple Employee");
            DBConnector.save(rollEmployee);
            RollEntity rollManager = new RollEntity();
            rollManager.setRollTitle("Branch Manager");
            DBConnector.save(rollManager);
        }
    }

    public static void creatCentralBranch() {
        List branchCount = DBConnector.query("SELECT branch FROM BankBranchEntity branch");
        if (branchCount.size() == 0) {
            BankBranchEntity newBranch = new BankBranchEntity();
            newBranch.setBankBranchName("Central");
            DBConnector.save(newBranch);
        }
    }
}
