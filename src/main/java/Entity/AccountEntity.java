package Entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER",length = 20,unique = true)
    private int accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_OWNER")
    private CustomerEntity accountOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_CREDIT_CARD",referencedColumnName = "ID")
    private CreditCardEntity accountCreditCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_BANK_BRANCH")
    private BankBranchEntity accountBankBranch;

    public AccountEntity() {

    }

    public AccountEntity(int accountNumber, CustomerEntity accountOwner, CreditCardEntity accountCreditCard, BankBranchEntity accountBankBranch) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountCreditCard = accountCreditCard;
        this.accountBankBranch = accountBankBranch;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", accountOwner=" + accountOwner +
                ", accountCreditCard=" + accountCreditCard +
                ", accountBankBranch=" + accountBankBranch +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CustomerEntity getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(CustomerEntity accountOwner) {
        this.accountOwner = accountOwner;
    }

    public CreditCardEntity getAccountCreditCard() {
        return accountCreditCard;
    }

    public void setAccountCreditCard(CreditCardEntity accountCreditCard) {
        this.accountCreditCard = accountCreditCard;
    }

    public BankBranchEntity getAccountBankBranch() {
        return accountBankBranch;
    }

    public void setAccountBankBranch(BankBranchEntity accountBankBranch) {
        this.accountBankBranch = accountBankBranch;
    }
}
