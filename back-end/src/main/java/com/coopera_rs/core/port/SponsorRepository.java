package com.coopera_rs.core.port;

import com.coopera_rs.infrastructure.repository.entity.SponsorEntity;

import java.util.List;

public interface SponsorRepository {
    List<SponsorEntity> findAllByOrderByIdDesc();
}
