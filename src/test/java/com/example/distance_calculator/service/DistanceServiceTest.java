package com.example.distance_calculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DistanceServiceTest {

    private final DistanceService distanceService = new DistanceService();

    @Test
    void testSumDistances_BothInMeters_OutputInMeters() {
        double result = distanceService.sumDistances(2.0, "METERS", 3.0, "METERS", "METERS");
        // Expected 2 + 3 = 5
        // assertEquals(expected, actual, delta): We allow a small delta for floating-point comparisons (e.g., 1e-6)
        assertEquals(5.0, result, 1e-6);
    }

    @Test
    void testSumDistances_BothInYards_OutputInYards() {
        double result = distanceService.sumDistances(2.0, "YARDS", 3.0, "YARDS", "YARDS");
        // Expected 2 + 3 = 5 yards
        assertEquals(5.0, result, 1e-6);
    }

    @Test
    void testSumDistances_YardsAndMeters_OutputMeters() {
        // 3 yards = 2.7432 meters (3 * 0.9144)
        // So total = 2.7432 + 5 = 7.7432 meters
        double result = distanceService.sumDistances(3.0, "YARDS", 5.0, "METERS", "METERS");
        assertEquals(7.7432, result, 1e-4);
    }

    @Test
    void testSumDistances_YardsAndMeters_OutputYards() {
        // 5 meters = 5 / 0.9144 yards = ~5.46807 yards
        // 3 yards + 5.46807 yards = ~8.46807 yards
        double result = distanceService.sumDistances(3.0, "YARDS", 5.0, "METERS", "YARDS");
        assertEquals(8.46807, result, 1e-5);
    }

    @Test
    void testUnsupportedUnit() {
        // Expect an exception when passing an unknown unit
        assertThrows(IllegalArgumentException.class, () ->
                distanceService.sumDistances(1.0, "FOOT", 2.0, "METERS", "METERS")
        );
    }
}

