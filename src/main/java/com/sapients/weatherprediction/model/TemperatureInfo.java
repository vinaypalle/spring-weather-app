package com.sapients.weatherprediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureInfo implements WeatherPredictor{

    private double minTemp;
    private double maxTemp;
    private List<WeatherAdvice> weatherAdvice;
    private String date;
}
