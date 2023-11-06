package io.mendirl.demo.pending;

import io.hypersistence.tsid.TSID;
import io.mendirl.demo.pending.entity.PendingEntity;
import io.mendirl.demo.pending.entity.TransactionEntity;
import io.mendirl.demo.pending.entity.TxCoreEntity;
import io.mendirl.demo.pending.repository.PendingRepository;
import io.mendirl.demo.pending.service.PendingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@TestConfiguration(value = "PendingService")
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"spring.jpa.show-sql=true", "spring.jpa.open-in-view=false"})
class PendingTest {

//    @Autowired
//    PendingService pendingService;

    @Autowired
    PendingRepository pendingRepository;

    TSID tsid = TSID.Factory.getTsid();

    @BeforeEach
    public void init() {
//        var transactionToPersist = TransactionEntity.builder().name("transaction1:" + tsid).build();
//        var txCoreToPersist = TxCoreEntity.builder().name("txcore1:" + tsid).build();
        var pendingToPersist = PendingEntity.builder().name("pending1:" + tsid).build();

//        txCoreToPersist.addTransaction(transactionToPersist);
//        pendingToPersist.addTransaction(transactionToPersist);

        pendingRepository.persistAndFlush(pendingToPersist);
    }

    @Test
    void test_insert() {
        var pendingretrievedV0 = pendingRepository.getReferenceById(1L);

        assertThat(pendingretrievedV0).isNotNull();
        assertThat(pendingretrievedV0.getId()).isNotNull();
        assertThat(pendingretrievedV0.getName()).startsWith("pending1");
        assertThat(pendingretrievedV0.getVersion()).isEqualTo((short)0);
//        assertThat(pendingretrievedV0.getTransactions()).hasSize(1);

        pendingretrievedV0.setName(pendingretrievedV0.getName() + ":" + tsid);
        var pendingretrievedV1 = pendingRepository.persist(pendingretrievedV0);

        assertThat(pendingretrievedV1).isNotNull();
        assertThat(pendingretrievedV1.getVersion()).isEqualTo((short)1);
    }

}
