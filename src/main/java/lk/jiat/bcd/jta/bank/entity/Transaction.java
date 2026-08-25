package lk.jiat.bcd.jta.bank.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@NamedQueries({
        @NamedQuery(name = "Transaction.findByAccountNo",
                    query = "SELECT t FROM Transaction t WHERE t.accoutNo = :accountNo ORDER BY t.timestamp DESC")
})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String accoutNo;;

    private String relatedAccountNo;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private double amount;

    private double balanceAfter;

    private LocalDateTime timestamp;

    public Transaction() {
    }

    public Transaction(String accoutNo, TransactionType type, double amout, double balanceAfter, String relatedAccountNo) {
        this.accoutNo = accoutNo;
        this.type = type;
        this.amount = amout;
        this.balanceAfter = balanceAfter;
        this.relatedAccountNo = relatedAccountNo;
        this.timestamp = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getAccoutNo() {
        return accoutNo;
    }

    public void setAccoutNo(String accoutNo) {
        this.accoutNo = accoutNo;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getRelatedAccountNo() {
        return relatedAccountNo;
    }

    public void setRelatedAccountNo(String relatedAccountNo) {
        this.relatedAccountNo = relatedAccountNo;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
