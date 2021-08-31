package Config;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConstantValue {
    //Regex
    public static final String TRANSFER_REGEX = "\\d{1,16}$";
    public static final String NATIONAL_CODE_REGEX = "\\d{10}";
    public static final String PHONE_NUMBER_REGEX = "\\d{11}";
    public static final String MENU_REGEX = "\\d{1}";
    public static final String DATE_FORMATTER_REGEX = "\\d{4}-\\d{2}-\\d{2}";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    public static final String NAME_REGEX = "^[a-zA-Z\\s]*$";
    //Query
    public static final String ALL_BRANCH_NON_ACTIVE = "SELECT bank FROM BankBranchEntity bank WHERE bank.bankBranchAdmin IS NULL ";
    public static final String ALL_BRANCH = "SELECT bank FROM BankBranchEntity bank";
    public static final String SEE_BRANCH = "SELECT manage.bankBranchAdmin FROM BankBranchEntity manage";
    public static final String ALL_EMPLOYEE = "SELECT emp FROM EmployeeEntity emp";
    public static final String ALL_ROLLS = "SELECT roll FROM RollEntity roll";
    public static final String FETCH_MANAGERS = "SELECT manage FROM EmployeeEntity manage WHERE manage.employeeRollTitle = 'Branch Manager'";
    public static final String FETCH_MANAGER_NON_ACTIVE = "SELECT manage FROM EmployeeEntity manage WHERE manage.employeeRollTitle LIKE Branch Manager AND manage.bankBranch IS NULL ";
    public static final String ALL_ACCOUNT = "SELECT allAcc FROM AccountEntity allAcc";
    //Bundle Message
    public static final String UNSUCCESS_CREDIT_CARD = "Your Request Failed If You Haven't Credit Card Please Try Later";
    public static final String SUCCESS_REQUEST = "Your Request Is Success Done ";
    public static final String UNSUCCESS_REQUEST = "Your Request Is Failed ";
    public static final String NOT_EMPLOYEE = "Employee Not Found";
    public static final String NOT_UNIQUE = "Your Information Already Exist";
    public static final String NOT_FOUND = "Your Information Not Found";
    public static final String NOT_USER = "User Not Found";
    public static final String USER_NAME = "User Name";
    public static final String FIRST_NAME = "First Name";
    public static final String LAST_NAME = "Last Name";
    public static final String NATIONAL_CODE = "National Code";
    public static final String PHONE_NUMBER = "Phone Number";
    public static final String PASSWORD = "Password";
    public static final String WRONG_PASSWORD = "Password Is Wrong";
    public static final String ACCOUNT_AMOUNT = "Account Amount";
    public static final String HAVE_CREDIT = "You Have Credit Card";
    public static final String BRANCH = "Branch";
    public static final String BRANCH_TITLE = "Id\t\tBranch Name";
    public static final String EMPLOYEE_TITLE = "Id\t\tEmployee Name\t\tBranch Name";
    public static final String CUSTOMER_TITLE = "User Name\t\tFirst Name\t\tLast Name\t\tNational Code\t\tAccount Number\t\tCredit Card Number\t\tCVV2 Number\t\tAmount";
    public static final String DESTINATION_CARD_INFO = "Id\t\tFirst Name\t\tLast Name\t\tNational Code\t\tAccount Number\t\tCredit Card Number\t\tBranch";
    public static final String NOT_VALID_INPUT = "Your Input Not Valid Choice Between Id Or Account Number or Credit Card Number";
    public static final String EMPLOYEE_INFORMATION = "Id\t\tFirst Name\t\tLast Name\t\tNationalCode";
    public static final String CHOICE_EMPLOYEE = "Please Choice Employee Id Is Behind List \n Id\t Employee UserName";
    public static final String CHOICE_ROLL = "Please Choice Roll Id Is Behind List \n Id\t Roll Title";
    public static final String NOT_ENOUGH_MONEY = "Not Enough Your Money For This Transaction";
    public static final String REQUEST_AMOUNT = "PLease Enter Your Amount Fee For Transfer";
    public static final String NOT_ACCOUNT_FOUND = "Not Found Any Account";
    public static final String DESTINATION_MESSAGE = "Please Choice Destination Card";
    public static final String WRONG_CVV2 = "Your Code IS Wrong Please Try Again";
    public static final String REQUEST_CVV2 = "Please Enter Your CVV2";
    public static final String END = "GoodLuck";
    //Generator
    public static final String NUMERIC_STRING = "0123456789";
    //Input
    public static Scanner SCANNER = new Scanner(System.in);
    //Arrays
    public static List<String> listString = new ArrayList<>();
    //Constant
    public static BigInteger TRANSFER_FEE = new BigInteger("500");

}
