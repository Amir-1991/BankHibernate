package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CUSTOMER_USER_NAME" ,length = 50,unique = true)
    private String customerUserName;

    @Column(name = "CUSTOMER_FIRST_NAME" ,length = 25)
    private String customerFirstName;

    @Column(name = "CUSTOMER_LAST_NAME" ,length = 25)
    private String customerLastName;

    @Column(name = "CUSTOMER_NATIONAL_NUMBER",length = 10,unique = true)
    private String customerNationalNumber;

    @Column(name = "PASSWORD",length = 25)
    private String password;

    @OneToMany(mappedBy = "accountOwner")
    private List<AccountEntity> accountOwner = new ArrayList<AccountEntity>();

    public CustomerEntity() {

    }

    public CustomerEntity(String customerUserName, String customerFirstName, String customerLastName, String customerNationalNumber, String password, List<AccountEntity> accountOwner) {
        this.customerUserName = customerUserName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerNationalNumber = customerNationalNumber;
        this.password = password;
        this.accountOwner = accountOwner;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", customerUserName='" + customerUserName + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerNationalNumber='" + customerNationalNumber + '\'' +
                ", password='" + password + '\'' +
                ", accountOwner=" + accountOwner +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerNationalNumber() {
        return customerNationalNumber;
    }

    public void setCustomerNationalNumber(String customerNationalNumber) {
        this.customerNationalNumber = customerNationalNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AccountEntity> getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(List<AccountEntity> accountOwner) {
        this.accountOwner = accountOwner;
    }
}
