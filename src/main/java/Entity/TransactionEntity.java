package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORIGIN_CARD")
    private CreditCardEntity originCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DESTINATION_CARD", referencedColumnName = "ID")
    private CreditCardEntity destinationCard;

    @Column(name = "TRANSFER_FEE")
    private String transferFee;

    @Column(name = "TRANSFER_DATE")
    private LocalDate transferDate;

    public TransactionEntity() {

    }

    public TransactionEntity(CreditCardEntity originCard
            , CreditCardEntity destinationCard
            , String transferFee
            , LocalDate transferDate) {
        this.originCard = originCard;
        this.destinationCard = destinationCard;
        this.transferFee = transferFee;
        this.transferDate = transferDate;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", originCard=" + originCard +
                ", destinationCard=" + destinationCard +
                ", transferFee=" + transferFee +
                ", transferDate=" + transferDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardEntity getOriginCard() {
        return originCard;
    }

    public void setOriginCard(CreditCardEntity originCard) {
        this.originCard = originCard;
    }

    public CreditCardEntity getDestinationCard() {
        return destinationCard;
    }

    public void setDestinationCard(CreditCardEntity destinationCard) {
        this.destinationCard = destinationCard;
    }

    public String getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(String transferFee) {
        this.transferFee = transferFee;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}
