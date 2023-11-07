package io.mendirl.demo.pending

import io.hypersistence.tsid.TSID
import io.mendirl.demo.pending.entity.PendingEntity
import io.mendirl.demo.pending.entity.TransactionEntity
import io.mendirl.demo.pending.entity.TxCoreEntity
import io.mendirl.demo.pending.service.PendingService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource


@TestConfiguration(value = "PendingService")
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = ["spring.jpa.show-sql=true"])
class PendingTest {

    @Autowired
    lateinit var pendingService: PendingService

    var tsid: TSID = TSID.Factory.getTsid()

    @BeforeEach
    fun init() {
        val transactionToPersist = TransactionEntity("transaction:$tsid")
        val txCoreToPersist = TxCoreEntity("txcore:$tsid")
        val pendingToPersist = PendingEntity( "pending1:$tsid")

        txCoreToPersist.addTransaction(transactionToPersist)
        pendingToPersist.addTransaction(transactionToPersist)

        pendingService.save(pendingToPersist)
    }

    @Test
    fun test_insert() {
        val pendingretrievedV0 = pendingService.getReferenceById(1L)

        assertThat(pendingretrievedV0).isNotNull
        assertThat(pendingretrievedV0.id).isNotNull
        assertThat(pendingretrievedV0.name).startsWith("pending1")
        assertThat(pendingretrievedV0.version).isEqualTo(0)
        assertThat(pendingretrievedV0.transactions).hasSize(1)

        pendingretrievedV0.name = "${pendingretrievedV0.name}:$tsid"
        val pendingretrievedV1 = pendingService.save(pendingretrievedV0)

        assertThat(pendingretrievedV1).isNotNull
        assertThat(pendingretrievedV1.version).isEqualTo(1)
    }

}