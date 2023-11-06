package io.mendirl.demo.pending.service;

import io.mendirl.demo.pending.entity.PendingEntity;
import io.mendirl.demo.pending.repository.PendingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PendingService {

    private final PendingRepository pendingRepository;

    public PendingService(PendingRepository pendingRepository) {
        this.pendingRepository = pendingRepository;
    }


//    @Transactional
    public PendingEntity save(PendingEntity pending) {
        return pendingRepository.persist(pending);
    }

//    @Transactional
    public PendingEntity getReferenceById(Long id) {
        return pendingRepository.getReferenceById(id);
    }

}
