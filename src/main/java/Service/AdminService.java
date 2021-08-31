package Service;

import Config.ConstantValue;
import Entity.AdminEntity;
import Entity.RollEntity;
import Repository.AdminRepository;
import Repository.RollRepository;
import View.AdminForm;
import View.MainForm;

import java.util.List;

public class AdminService {
    public static void signInAdmin() {
        showMessage("User Name");
        ConstantValue.listString.add(0, ConstantValue.SCANNER.next());
        showMessage("Password");
        ConstantValue.listString.add(1, ConstantValue.SCANNER.next());
        List<AdminEntity> resultAdmin = AdminRepository.load(ConstantValue.listString);
        if (resultAdmin.size() == 0) {
            System.out.println("Admin Not Found");
            MainForm.menu();
        } else if (!resultAdmin.get(0).getAdminPassword().equals(ConstantValue.listString.get(1))) {
            System.out.println("Password Is Wrong ");
        } else {
            AdminForm.adminPanel(resultAdmin);
        }
    }

    public static void createRoll(List<AdminEntity> resultAdmin) {
        RollEntity newRoll = new RollEntity();
        showMessage("Roll Title");
        newRoll.setRollTitle(ConstantValue.SCANNER.next());
        RollRepository.save(newRoll);
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
