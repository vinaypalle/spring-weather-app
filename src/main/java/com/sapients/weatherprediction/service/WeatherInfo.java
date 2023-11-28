package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherData;
import com.sapients.weatherprediction.model.WeatherPredictor;

import java.util.List;
import java.util.Map;

public interface WeatherInfo {
    List<WeatherPredictor> findWeatherInfo(Map<String, List<WeatherData>> weatherMap);
}
