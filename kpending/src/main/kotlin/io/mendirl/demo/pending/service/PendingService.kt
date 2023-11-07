package io.mendirl.demo.pending.service

import io.mendirl.demo.pending.entity.PendingEntity
import io.mendirl.demo.pending.repository.PendingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PendingService(val pendingRepository: PendingRepository) {

    @Transactional
    fun save(pending: PendingEntity): PendingEntity {
        return pendingRepository.saveAndFlush(pending)
    }

    @Transactional
    fun getReferenceById(id: Long): PendingEntity {
        return pendingRepository.getReferenceById(id)
    }

}