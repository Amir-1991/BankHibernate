package Service;

import Config.ConstantValue;
import Entity.BankBranchEntity;
import Entity.EmployeeEntity;
import Repository.BankBranchRepository;
import Repository.EmployeeRepository;
import View.AdminForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankBranchService {
    public static void createBankBranch() {
        Scanner scanner = new Scanner(System.in);
        BankBranchEntity newBankBranch = new BankBranchEntity();
        String inputCustomer;
        showMessage("Branch Name");
        do {
            inputCustomer = scanner.next();
            newBankBranch.setBankBranchName(inputCustomer);
        } while (inputCustomer.matches(ConstantValue.NAME_REGEX));
        List<EmployeeEntity> manage = EmployeeRepository.allManagers();
        if (manage.size() == 0) {
            System.out.println("No Manager In Employee List");
        } else {
            System.out.println(" Please Enter Your Manager \n" +
                    " Id \t Manage Name ");
            for (int manageCount = 0; manageCount < manage.size(); manageCount++) {
                System.out.println((manageCount + 1) + " \t " + manage.get(manageCount).getEmployeeUserName());
            }
            inputCustomer = scanner.next();
            newBankBranch.setBankBranchAdmin(inputCustomer);
        }
        BankBranchRepository.save(newBankBranch);
    }

    public static void asSignAdmin() {
        Scanner scanner = new Scanner(System.in);
        List<String> managerBranch = new ArrayList<>();
        String inputManBranch;
        List<BankBranchEntity> bankBranchEntities = BankBranchRepository.allBranches();
        if (bankBranchEntities.size()==0){
            System.out.println("All Banks Have Manager");
            AdminForm.mainDashboard();
        }else{
            for (int branchCounter = 0; branchCounter < bankBranchEntities.size(); branchCounter++) {
                System.out.println((branchCounter+1)+": "+bankBranchEntities.get(branchCounter).getBankBranchName());
            }
            showMessage("Branch");
            inputManBranch = scanner.next();
            managerBranch.add(0,inputManBranch);
        }
        List<EmployeeEntity> employeeEntities = EmployeeRepository.allDeActiveManagers();
        if (employeeEntities.size()==0){
            System.out.println("All Mangers Have Job");
            AdminForm.mainDashboard();
        }else{
            for (int manageCounter = 0; manageCounter < employeeEntities.size(); manageCounter++) {
                System.out.println((manageCounter+1)+": "+employeeEntities.get(manageCounter).getEmployeeUserName());
            }
            showMessage("Manager");
            inputManBranch = scanner.next();
            managerBranch.add(1,inputManBranch);
        }
        EmployeeRepository.setBranch(managerBranch);
        BankBranchRepository.setManager(managerBranch);
        System.out.println("Assignee Is Complete");
        AdminForm.mainDashboard();
    }

    public static void seeBranchManager() {
        List<BankBranchEntity> seeResult = BankBranchRepository.seeBranchManager();
        for (int manageCounter = 0; manageCounter < seeResult.size(); manageCounter++) {
            System.out.println((manageCounter + 1) + ": \t" + seeResult.get(manageCounter).getBankBranchAdmin() + "\t" + seeResult.get(manageCounter).getBankBranchName());
        }
    }

    public static void showMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
