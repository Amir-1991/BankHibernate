package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BANK_BRANCH")
public class BankBranchEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BANK_BRANCH_NAME",length = 30,unique = true)
    private String bankBranchName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_BRANCH_ADMIN",referencedColumnName = "ID")
    private EmployeeEntity bankBranchAdmin;

    @OneToMany(mappedBy = "bankEmployees")
    private List<EmployeeEntity> bankEmployee = new ArrayList<EmployeeEntity>();

    public BankBranchEntity() {

    }

    public BankBranchEntity(String bankBranchName, EmployeeEntity bankBranchAdmin, List<EmployeeEntity> bankEmployee) {
        this.bankBranchName = bankBranchName;
        this.bankBranchAdmin = bankBranchAdmin;
        this.bankEmployee = bankEmployee;
    }

    @Override
    public String toString() {
        return "BankBranchEntity{" +
                "id=" + id +
                ", bankBranchName='" + bankBranchName + '\'' +
                ", bankBranchAdmin='" + bankBranchAdmin + '\'' +
                ", bankEmployee=" + bankEmployee +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public EmployeeEntity getBankBranchAdmin() {
        return bankBranchAdmin;
    }

    public void setBankBranchAdmin(EmployeeEntity bankBranchAdmin) {
        this.bankBranchAdmin = bankBranchAdmin;
    }

    public List<EmployeeEntity> getBankEmployee() {
        return bankEmployee;
    }

    public void setBankEmployee(List<EmployeeEntity> bankEmployee) {
        this.bankEmployee = bankEmployee;
    }
}
