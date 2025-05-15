package com.coopera_rs.infrastructure.repository.adapter;

import com.coopera_rs.core.port.SponsorRepository;
import com.coopera_rs.infrastructure.repository.SpringDataSponsorRepository;
import com.coopera_rs.infrastructure.repository.entity.SponsorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaSponsorRepositoryAdapter implements SponsorRepository {

    private final SpringDataSponsorRepository springDataSponsorRepository;

    @Override
    public List<SponsorEntity> findAllByOrderByIdDesc() {
        return springDataSponsorRepository.findAllByOrderByIdDesc();
    }
}
