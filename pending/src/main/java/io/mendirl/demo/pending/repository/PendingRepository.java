package io.mendirl.demo.pending.repository;

import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import io.mendirl.demo.pending.entity.PendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingRepository extends BaseJpaRepository<PendingEntity, Long> {

//    @Override
//    PendingEntity getReferenceById(Long id);
//
//    @Override
//    PendingEntity saveAndFlush(PendingEntity pending);

}
