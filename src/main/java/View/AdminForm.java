package View;

import Config.ConstantValue;
import Entity.AdminEntity;
import Service.AdminService;
import Service.BankBranchService;
import Service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class AdminForm {

    public static void adminPanel(List<AdminEntity> resultAdmin) {
        Scanner scanner = new Scanner(System.in);
        String adminChoice;
        mainDashboard();
        do {
            adminChoice =scanner.next();
        }while (!adminChoice.matches(ConstantValue.MENU_REGEX));
        switch (adminChoice){
            case "1":
                BankBranchService.createBankBranch();
                break;
            case "2":
                BankBranchService.seeBranchAdmins();
                break;
            case "3":
                AdminService.createRoll();
                break;
            case "0":
                MainForm.menu();
                break;
        }
    }

    public static void mainDashboard(){
        System.out.println("Welcome To Your Dashboard \n" +
                "1: Creat Bank Branch \n" +
                "2: See All Branch Administrators \n" +
                "3: Create Employee Roll \n" +
                "0: Exit");
    }
}
