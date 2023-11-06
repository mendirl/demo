package io.mendirl.demo.pending.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PendingEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Version
    private Short version;
    private String name;
//    @Default
//    @OneToMany(mappedBy = "pending", cascade = {PERSIST}, fetch = EAGER)
//    private List<TransactionEntity> transactions = new ArrayList<>();

//    public void addTransaction(TransactionEntity transaction) {
//        transactions.add(transaction);
//        transaction.setPending(this);
//    }

}
