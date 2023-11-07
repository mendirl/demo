package io.mendirl.demo.pending.repository

import io.mendirl.demo.pending.entity.PendingEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PendingRepository: JpaRepository<PendingEntity, Long> {

    override fun getReferenceById(id: Long): PendingEntity

    override fun <S : PendingEntity?> saveAndFlush(entity: S & Any): S & Any

}
