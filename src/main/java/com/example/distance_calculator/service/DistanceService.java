package com.example.distance_calculator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistanceService {

    private static final double YARD_TO_METER = 0.9144;

    public double convertToMeters(double distance, String unit) {
        log.info("Converting {} {} to meters", distance, unit);

        if ("YARDS".equalsIgnoreCase(unit)) {
            return distance * YARD_TO_METER;
        } else if ("METERS".equalsIgnoreCase(unit)) {
            return distance;
        } else {
            throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
    }

    public double convertFromMeters(double distance, String targetUnit) {
        if ("YARDS".equalsIgnoreCase(targetUnit)) {
            return distance / YARD_TO_METER;
        } else if ("METERS".equalsIgnoreCase(targetUnit)) {
            return distance;
        } else {
            throw new IllegalArgumentException("Unsupported unit: " + targetUnit);
        }
    }

    public double sumDistances(double distance1, String unit1,
                               double distance2, String unit2,
                               String outputUnit) {
        double dist1InMeters = convertToMeters(distance1, unit1);
        double dist2InMeters = convertToMeters(distance2, unit2);

        double totalInMeters = dist1InMeters + dist2InMeters;

        return convertFromMeters(totalInMeters, outputUnit);
    }
}
