package io.mendirl.demo.pending.entity

import jakarta.persistence.*
import jakarta.persistence.CascadeType.PERSIST
import jakarta.persistence.FetchType.EAGER
import jakarta.persistence.GenerationType.*

@Entity
class PendingEntity(
        var name: String,
        @OneToMany(mappedBy = "pending", cascade = [PERSIST], fetch = EAGER)
        val transactions: MutableList<TransactionEntity> = mutableListOf(),
        @Id
        @GeneratedValue(strategy = IDENTITY)
        val id: Long? = null,
        @Version
        val version: Short? = null
) {
    fun addTransaction(transaction: TransactionEntity) {
        transactions.add(transaction)
        transaction.pending = this
    }
}