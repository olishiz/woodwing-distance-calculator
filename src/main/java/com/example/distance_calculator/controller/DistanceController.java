package com.example.distance_calculator.controller;

import com.example.distance_calculator.dto.DistanceRequest;
import com.example.distance_calculator.dto.DistanceResponse;
import com.example.distance_calculator.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distance")
@RequiredArgsConstructor
public class DistanceController {

    private final DistanceService distanceService;

    @PostMapping("/sum")
    public DistanceResponse sumDistances(@RequestBody DistanceRequest request) {
        double total = distanceService.sumDistances(
                request.getDistance1(),
                request.getUnit1(),
                request.getDistance2(),
                request.getUnit2(),
                request.getOutputUnit()
        );

        // Convert outputUnit to uppercase for consistency
        return new DistanceResponse(total, request.getOutputUnit().toUpperCase());
    }
}
