package io.mendirl.demo.pending.entity

import jakarta.persistence.*
import jakarta.persistence.CascadeType.PERSIST
import jakarta.persistence.GenerationType.IDENTITY

@Entity
class TransactionEntity(
        val name: String,
        @ManyToOne(cascade = [PERSIST])
        var pending: PendingEntity? = null,
        @ManyToOne(cascade = [PERSIST])
        var txCore: TxCoreEntity? = null,
        @Id
        @GeneratedValue(strategy = IDENTITY)
        val id: Long? = null,
        @Version
        val version: Short? = null
) {

}
