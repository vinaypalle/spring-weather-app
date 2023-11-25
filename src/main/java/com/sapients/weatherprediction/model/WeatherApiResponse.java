package com.sapients.weatherprediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherApiResponse {

    private String cod;
    private int message;
    private int cnt;
    private List<WeatherData> list;
}
