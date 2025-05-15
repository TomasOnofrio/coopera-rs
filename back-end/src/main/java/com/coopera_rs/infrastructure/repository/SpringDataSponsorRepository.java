package com.coopera_rs.infrastructure.repository;

import com.coopera_rs.infrastructure.repository.entity.SponsorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataSponsorRepository extends JpaRepository<SponsorEntity, Long> {
    List<SponsorEntity> findAllByOrderByIdDesc();
}
