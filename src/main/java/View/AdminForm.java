package View;

import Config.ConstantValue;
import Entity.AdminEntity;
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
                MainForm.menu();
                break;
        }
    }

    public static void mainDashboard(){
        System.out.println("Welcome To Your Dashboard \n" +
                "1: Creat Bank Branch \n" +
                "3: See All Branch Administrators \n" +
                "4: Exit");
    }
}
