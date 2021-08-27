package View;

import Config.ConstantValue;
import Entity.AdminEntity;
import Entity.BankBranchEntity;
import Repository.BankBranchRepository;
import Service.AdminService;
import Service.BankBranchService;
import Service.CustomerService;
import Service.EmployeeService;

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
                BankBranchService.asSignAdmin();
                break;
            case "3":
                EmployeeService.asSignRoll();
            case "4":
                BankBranchService.seeBranchManager();
                break;
            case "5":
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
                "2: Assignee Branch Administrator \n" +
                "3: Assignee Employee Roll \n" +
                "4: See All Branch Administrators \n" +
                "5: Create Employee Roll \n" +
                "0: Exit");
    }
}
