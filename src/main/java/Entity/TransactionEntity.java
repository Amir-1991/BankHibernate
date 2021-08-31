package Entity;

import javax.persistence.*;

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

    public TransactionEntity() {

    }

    public TransactionEntity(CreditCardEntity originCard
            , CreditCardEntity destinationCard
            , String transferFee) {
        this.originCard = originCard;
        this.destinationCard = destinationCard;
        this.transferFee = transferFee;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", originCard=" + originCard +
                ", destinationCard=" + destinationCard +
                ", transferFee=" + transferFee +
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
}
