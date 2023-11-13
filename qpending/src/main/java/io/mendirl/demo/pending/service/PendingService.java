package io.mendirl.demo.pending.service;

import io.mendirl.demo.pending.entity.PendingEntity;
import io.mendirl.demo.pending.repository.PendingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PendingService {

    private final PendingRepository pendingRepository;

    @Inject
    public PendingService(PendingRepository pendingRepository) {
        this.pendingRepository = pendingRepository;
    }

    @Transactional
    public PendingEntity save(PendingEntity pending) {
        pendingRepository.persist(pending);
        return pending;
    }

    @Transactional
    public PendingEntity getReferenceById(Long id) {
        return pendingRepository.findById(id);
    }

}
