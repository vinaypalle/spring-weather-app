package com.sapients.weatherprediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherPredictorResponse {

    private int status;
    private List<TemperatureInfo> data;
}
