package com.sapients.weatherprediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WindInfo {
    private double speed;
    private int deg;
    private double gust;
}
