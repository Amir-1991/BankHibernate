package Service;

import Entity.AdminEntity;
import Entity.RollEntity;
import Repository.AdminRepository;
import Repository.RollRepository;
import View.AdminForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    public static void signInAdmin() {
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showMessage("User Name");
        logInfo.add(0, logInScanner.next());
        showMessage("Password");
        logInfo.add(1, logInScanner.next());
        List<AdminEntity> resultAdmin = AdminRepository.load(logInfo);
        if (resultAdmin.size() == 0) {
            System.out.println("Admin Not Found");
        } else if (!resultAdmin.get(0).getAdminPassword().equals(logInfo.get(1))) {
            System.out.println("Password Is Wrong ");
        } else {
            AdminForm.adminPanel(resultAdmin);
        }
    }

    public static void createRoll() {
        Scanner rollScanner = new Scanner(System.in);
        RollEntity newRoll = new RollEntity();
        showMessage("Roll Title");
        newRoll.setRollTitle(rollScanner.next());
        RollRepository.save(newRoll);
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
