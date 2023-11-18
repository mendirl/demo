package io.mendirl.demo.pending.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class TransactionEntity extends PanacheEntity {

    @Version
    private Short version;
    private String name;
    @ManyToOne(cascade = {PERSIST})
    private PendingEntity pending;
    @ManyToOne(cascade = {PERSIST})
    private TxCoreEntity txCore;

    @GeneratedValue(strategy = IDENTITY)
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

    public void setName(String name) {
        this.name = name;
    }

    public PendingEntity getPending() {
        return pending;
    }

    public void setPending(PendingEntity pending) {
        this.pending = pending;
    }

    public TxCoreEntity getTxCore() {
        return txCore;
    }

    public void setTxCore(TxCoreEntity txCore) {
        this.txCore = txCore;
    }
}
