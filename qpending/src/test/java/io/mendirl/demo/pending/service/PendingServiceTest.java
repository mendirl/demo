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
    EntityManager entityManager;
    @Inject
    PendingService pendingService;
    @Inject
    PendingRepository pendingRepository;

    TSID tsid = TSID.Factory.getTsid();

    @Transactional
    @BeforeEach
    public void init() {
        var pendingToPersist = new PendingEntity().setName("pending1:" + tsid);

        pendingRepository.persistAndFlush(pendingToPersist);
    }

    @Test
    void test_insert() {
        var pendingretrievedV0 = pendingService.getReferenceById(1L);

        assertThat(pendingretrievedV0).isNotNull();
        assertThat(pendingretrievedV0.getId()).isNotNull();
        assertThat(pendingretrievedV0.getName()).startsWith("pending1");
        assertThat(pendingretrievedV0.getVersion()).isEqualTo((short) 0);
    }


}
