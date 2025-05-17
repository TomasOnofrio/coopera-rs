package com.coopera_rs.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopera_rs.application.service.StoreService;
import com.coopera_rs.core.domain.StorePhoto;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/store_photos/{id}")
    public ResponseEntity<List<StorePhoto>> getStorePhoto(@PathVariable long id){
        List<StorePhoto> photos = storeService.getStorePhotos(id);

        if (photos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(photos);
    }
}
