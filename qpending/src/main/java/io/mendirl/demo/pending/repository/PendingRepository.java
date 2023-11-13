package io.mendirl.demo.pending.repository;

import io.mendirl.demo.pending.entity.PendingEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PendingRepository implements PanacheRepository<PendingEntity> {

//    @Override
//    PendingEntity getReferenceById(Long id);
//
//    @Override
//    PendingEntity saveAndFlush(PendingEntity pending);

}
