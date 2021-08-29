package Entity;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCardEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREDIT_CARD_NUMBER",length = 8,unique = true)
    private int creditCardNumber;

    @OneToOne(mappedBy = "accountCreditCard")
    private AccountEntity creditCardAccount;

    public CreditCardEntity() {

    }

    public CreditCardEntity(int creditCardNumber, AccountEntity creditCardAccount) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardAccount = creditCardAccount;
    }

    @Override
    public String toString() {
        return "CreditCardEntity{" +
                "id=" + id +
                ", creditCardNumber=" + creditCardNumber +
                ", creditCardAccount=" + creditCardAccount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public AccountEntity getCreditCardAccount() {
        return creditCardAccount;
    }

    public void setCreditCardAccount(AccountEntity creditCardAccount) {
        this.creditCardAccount = creditCardAccount;
    }
}
