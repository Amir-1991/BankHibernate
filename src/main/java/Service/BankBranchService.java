package Service;

import Config.ConstantValue;
import Entity.AdminEntity;
import Entity.BankBranchEntity;
import Entity.EmployeeEntity;
import Repository.BankBranchRepository;
import Repository.EmployeeRepository;
import View.AdminForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankBranchService {
    public static void createBankBranch(List<AdminEntity> resultAdmin) {
        Scanner scanner = new Scanner(System.in);
        BankBranchEntity newBankBranch = new BankBranchEntity();
        String inputCustomer;
        showMessage("Branch Name");
        do {
            inputCustomer = scanner.next();
            newBankBranch.setBankBranchName(inputCustomer);
        } while (!inputCustomer.matches(ConstantValue.NAME_REGEX));
        List<EmployeeEntity> manage = EmployeeRepository.allManagers(resultAdmin);
        if (manage.size() == 0) {
            System.out.println("No Manager In Employee List");
            AdminForm.adminPanel(resultAdmin);
        } else {
            System.out.println(" Please Enter Your Manager Id \n" +
                    " Id \t Manage Name ");
            for (int manageCount = 0; manageCount < manage.size(); manageCount++) {
                System.out.println((manageCount + 1) + " \t " + manage.get(manageCount).getEmployeeUserName());
            }
            do {

                inputCustomer = scanner.next();
            }while (inputCustomer.matches(ConstantValue.MENU_REGEX));
            newBankBranch.setBankBranchAdmin(manage.get((Integer.parseInt(inputCustomer))-1));
            BankBranchRepository.save(newBankBranch);
            AdminForm.adminPanel(resultAdmin);
        }
    }

    public static void asSignAdmin(List<AdminEntity> resultAdmin) {
        Scanner scanner = new Scanner(System.in);
        List<String> managerBranch = new ArrayList<>();
        int inputManBranch = 0;
        int inputManEmp = 0;
        List<BankBranchEntity> bankBranchEntities = BankBranchRepository.allBranchesNoneActive();
        if (bankBranchEntities.size()==0){
            System.out.println("All Banks Have Manager");
            AdminForm.mainDashboard();
        }else{
            for (int branchCounter = 0; branchCounter < bankBranchEntities.size(); branchCounter++) {
                System.out.println((branchCounter+1)+": "+bankBranchEntities.get(branchCounter).getBankBranchName());
            }
            showMessage("Branch Id");
            inputManBranch = scanner.nextInt();
        }
        List<EmployeeEntity> employeeEntities = EmployeeRepository.allDeActiveManagers();
        if (employeeEntities.size()==0){
            System.out.println("All Mangers Have Job");
            AdminForm.adminPanel(resultAdmin);
        }else{
            for (int manageCounter = 0; manageCounter < employeeEntities.size(); manageCounter++) {
                System.out.println((manageCounter+1)+": "+employeeEntities.get(manageCounter).getEmployeeUserName());
            }
            showMessage("Manager Id");
            inputManEmp = scanner.nextInt();
        }
        EmployeeService.update(bankBranchEntities.get(inputManBranch-1));
        BankBranchRepository.update(employeeEntities.get(inputManEmp-1));
        System.out.println("Assignee Is Complete");
        AdminForm.adminPanel(resultAdmin);
    }

    public static void seeBranchManager(List<AdminEntity> resultAdmin) {
        List<BankBranchEntity> seeResult = BankBranchRepository.seeBranchManager();
        for (int manageCounter = 0; manageCounter < seeResult.size(); manageCounter++) {
            System.out.println((manageCounter + 1) + ": \t" + seeResult.get(manageCounter).getBankBranchAdmin() + "\t" + seeResult.get(manageCounter).getBankBranchName());
        }
        AdminForm.adminPanel(resultAdmin);
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
