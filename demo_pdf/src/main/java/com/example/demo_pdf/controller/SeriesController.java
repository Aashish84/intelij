package com.example.demo_pdf.controller;

import com.example.demo_pdf.service.GetSeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesController {
    private final GetSeriesService getSeriesService;

    public SeriesController(GetSeriesService getSeriesService) {
        this.getSeriesService = getSeriesService;
    }

    @GetMapping("/series")
    public ResponseEntity<?> getSeries() {
        return ResponseEntity.ok(getSeriesService.getSeries());
    }
}
