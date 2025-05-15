package com.coopera_rs.infrastructure.repository.mapper;

import com.coopera_rs.core.Sponsor;
import com.coopera_rs.infrastructure.repository.entity.SponsorEntity;

public class SponsorMapper {

    public static SponsorEntity toEntity(Sponsor sponsor){
        SponsorEntity sponsorEntity = new SponsorEntity();
        sponsorEntity.setId(sponsor.getId());
        sponsorEntity.setName(sponsor.getName());
        sponsorEntity.setImageUrl(sponsor.getImageUrl());
        sponsorEntity.setUrl(sponsor.getUrl());
        return sponsorEntity;
    }

    public static Sponsor toDomain(SponsorEntity sponsorEntity){
        return new Sponsor(
                sponsorEntity.getId(),
                sponsorEntity.getName(),
                sponsorEntity.getImageUrl(),
                sponsorEntity.getUrl()
        );
    }
}
