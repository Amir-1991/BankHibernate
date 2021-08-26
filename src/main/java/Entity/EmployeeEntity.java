package Entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EMPLOYEE_USER_NAME")
    private String employeeUserName;

    @Column(name = "EMPLOYEE_FIRST_NAME")
    private String employeeFirstName;

    @Column(name = "EMPLOYEE_LAST_NAME")
    private String employeeLastName;

    @Column(name = "EMPLOYEE_NATIONAL_CODE")
    private String employeeNationalCode;

    @Column(name = "EMPLOYEE_PHONE_NUMBER")
    private String employeePhoneNumber;

    @Column(name = "EMPLOYEE_PASSWORD")
    private String employeePassword;

    @Column(name = "EMPLOYEE_ROLL_TITLE")
    private String employeeRollTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_BRANCH")
    private BankBranchEntity bankEmployees;

    public EmployeeEntity() {

    }

    public EmployeeEntity(String employeeUserName
            , String employeeFirstName
            , String employeeLastName
            , String employeeNationalCode
            , String employeePhoneNumber
            , String employeePassword
            , String employeeRollTitle
            , BankBranchEntity bankEmployees) {
        this.employeeUserName = employeeUserName;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeNationalCode = employeeNationalCode;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeePassword = employeePassword;
        this.employeeRollTitle = employeeRollTitle;
        this.bankEmployees = bankEmployees;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", employeeUserName='" + employeeUserName + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeeNationalCode='" + employeeNationalCode + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                ", employeeRollTitle='" + employeeRollTitle + '\'' +
                ", bankEmployees=" + bankEmployees +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeNationalCode() {
        return employeeNationalCode;
    }

    public void setEmployeeNationalCode(String employeeNationalCode) {
        this.employeeNationalCode = employeeNationalCode;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeRollTitle() {
        return employeeRollTitle;
    }

    public void setEmployeeRollTitle(String employeeRollTitle) {
        this.employeeRollTitle = employeeRollTitle;
    }

    public BankBranchEntity getBankEmployees() {
        return bankEmployees;
    }

    public void setBankEmployees(BankBranchEntity bankEmployees) {
        this.bankEmployees = bankEmployees;
    }
}
