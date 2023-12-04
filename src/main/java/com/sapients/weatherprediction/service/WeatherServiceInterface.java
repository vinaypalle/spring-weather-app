package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherAdviceResponse;

import java.util.List;

public interface WeatherServiceInterface {

    List<WeatherAdviceResponse> fetchWeatherInfo(String location, String appid, String cnt);
}
