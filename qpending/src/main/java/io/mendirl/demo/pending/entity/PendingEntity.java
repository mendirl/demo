package io.mendirl.demo.pending.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PendingEntity /*extends PanacheEntity */ {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Version
    private Short version;
    private String name;

    @OneToMany(mappedBy = "pending", cascade = {PERSIST}, fetch = EAGER)
    private List<TransactionEntity> transactions = new ArrayList<>();

    public void addTransaction(TransactionEntity transaction) {
        transactions.add(transaction);
        transaction.setPending(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public PendingEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

}
