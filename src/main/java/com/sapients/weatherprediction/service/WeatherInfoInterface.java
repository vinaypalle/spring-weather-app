package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.TemperatureInfo;
import com.sapients.weatherprediction.model.WeatherData;

import java.util.List;
import java.util.Map;

public interface WeatherInfoInterface {
    List<TemperatureInfo> findWeatherInfo(Map<String, List<WeatherData>> weatherMap);
}
