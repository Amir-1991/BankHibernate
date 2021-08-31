package Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCardEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREDIT_CARD_NUMBER", length = 16, unique = true)
    private String creditCardNumber;

    @Column(name = "ACCOUNT_CVV2_NUMBER", length = 4, unique = true)
    private String accountCvv2Number;

    @OneToOne(mappedBy = "accountCreditCard")
    private AccountEntity creditCardAccount;

    @Column(name = "ACCOUNT_SALARY", length = 20)
    private String creditSalary;

    @Column(name = "CREDIT_CARD_EXP_DATE")
    private LocalDate creditCardExpDate;

    @OneToMany(mappedBy = "originCard")
    private List<TransactionEntity> originCard = new ArrayList<TransactionEntity>();

    public CreditCardEntity() {

    }

    public CreditCardEntity(String creditCardNumber
            , String accountCvv2Number
            , AccountEntity creditCardAccount
            , String creditSalary
            , LocalDate creditCardExpDate) {
        this.creditCardNumber = creditCardNumber;
        this.accountCvv2Number = accountCvv2Number;
        this.creditCardAccount = creditCardAccount;
        this.creditSalary = creditSalary;
        this.creditCardExpDate = creditCardExpDate;
    }

    @Override
    public String toString() {
        return "CreditCardEntity{" +
                "id=" + id +
                ", creditCardNumber=" + creditCardNumber +
                ", accountCvv2Number=" + accountCvv2Number +
                ", creditCardAccount=" + creditCardAccount +
                ", creditSalary=" + creditSalary +
                ", creditCardExpDate=" + creditCardExpDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getAccountCvv2Number() {
        return accountCvv2Number;
    }

    public void setAccountCvv2Number(String accountCvv2Number) {
        this.accountCvv2Number = accountCvv2Number;
    }

    public AccountEntity getCreditCardAccount() {
        return creditCardAccount;
    }

    public void setCreditCardAccount(AccountEntity creditCardAccount) {
        this.creditCardAccount = creditCardAccount;
    }

    public String getCreditSalary() {
        return creditSalary;
    }

    public void setCreditSalary(String creditSalary) {
        this.creditSalary = creditSalary;
    }

    public LocalDate getCreditCardExpDate() {
        return creditCardExpDate;
    }

    public void setCreditCardExpDate(LocalDate creditCardExpDate) {
        this.creditCardExpDate = creditCardExpDate;
    }

}
