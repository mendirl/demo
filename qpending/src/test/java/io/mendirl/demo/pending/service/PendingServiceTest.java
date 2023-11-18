package io.mendirl.demo.pending.service;

import io.hypersistence.tsid.TSID;
import io.mendirl.demo.pending.entity.PendingEntity;
import io.mendirl.demo.pending.repository.PendingRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class PendingServiceTest {

    @Inject
    PendingService pendingService;
    @Inject
    PendingRepository pendingRepository;

    TSID tsid = TSID.Factory.getTsid();

    @Transactional
    @BeforeEach
    public void init() {
        var pendingToPersist1 = new PendingEntity().setName("pending1:" + tsid);
        pendingToPersist1.persistAndFlush();

        var pendingToPersist2 = new PendingEntity().setName("pending2:" + tsid);
        pendingRepository.persistAndFlush(pendingToPersist2);
    }

    @Test
    void test_insert() {
        PendingEntity pendingretrieved1V0 = PendingEntity.findById(1L);
        assertThat(pendingretrieved1V0).isNotNull();
        assertThat(pendingretrieved1V0.getId()).isNotNull();
        assertThat(pendingretrieved1V0.getName()).startsWith("pending1");
        assertThat(pendingretrieved1V0.getVersion()).isEqualTo((short) 0);

        PendingEntity pendingretrieved2V0 = pendingService.getReferenceById(2L);
        assertThat(pendingretrieved2V0).isNotNull();
        assertThat(pendingretrieved2V0.getId()).isNotNull();
        assertThat(pendingretrieved2V0.getName()).startsWith("pending2");
        assertThat(pendingretrieved2V0.getVersion()).isEqualTo((short) 0);
    }


}
