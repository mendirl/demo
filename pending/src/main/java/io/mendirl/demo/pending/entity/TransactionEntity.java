package io.mendirl.demo.pending.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Version
    private Short version;
    private String name;
    @ToString.Exclude
    @ManyToOne(cascade = {PERSIST})
    private PendingEntity pending;
    @ManyToOne(cascade = {PERSIST})
    private TxCoreEntity txCore;

}
