package com.coopera_rs.web.controllers;

import com.coopera_rs.application.service.SponsorService;
import com.coopera_rs.core.Sponsor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sponsors")
@RequiredArgsConstructor
public class SponsorController {

    private final SponsorService sponsorService;

    @GetMapping
    public ResponseEntity<List<Sponsor>> getAllSponsorsByOrder(@RequestHeader("Authorization") String authorizationHeader) {
        List<Sponsor> sponsors = sponsorService.getAllSponsorsByOrder();
        return ResponseEntity.ok(sponsors);
    }
}
