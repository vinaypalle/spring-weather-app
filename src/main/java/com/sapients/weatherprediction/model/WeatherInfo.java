package com.sapients.weatherprediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {

    private int id;
    private String main;
    private String description;
    private String icon;

}
