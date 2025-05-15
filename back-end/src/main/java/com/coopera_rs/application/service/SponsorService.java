package com.coopera_rs.application.service;

import com.coopera_rs.core.Sponsor;
import com.coopera_rs.core.port.SponsorRepository;
import com.coopera_rs.infrastructure.repository.mapper.SponsorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SponsorService {

    private final SponsorRepository sponsorRepository;

    public List<Sponsor> getAllSponsorsByOrder() {
        return sponsorRepository.findAllByOrderByIdDesc().stream().map(SponsorMapper::toDomain).toList();
    }
}