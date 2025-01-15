package com.example.distance_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanceRequest {
    private double distance1;
    private String unit1;
    private double distance2;
    private String unit2;
    private String outputUnit;
}
