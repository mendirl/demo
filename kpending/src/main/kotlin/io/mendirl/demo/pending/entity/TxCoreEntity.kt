package io.mendirl.demo.pending.entity

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
class TxCoreEntity(
        val name: String,
        @OneToMany(mappedBy = "txCore", cascade = [CascadeType.PERSIST])
        val transactions: MutableList<TransactionEntity> = mutableListOf(),
        @Id
        @GeneratedValue(strategy = IDENTITY)
        val id: Long? = null,
        @Version
        val version: Short? = null
){
        fun addTransaction(transaction: TransactionEntity) {
                transactions.add(transaction)
                transaction.txCore = this
        }
}