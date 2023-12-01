package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherAdvice;

public class ThunderstormAdvice implements WeatherAdviceInterface{

    private static final String THUNDERSTORM_WEATHER_ADVICE = "Don’t step out! A Storm is brewing!";
    private WeatherAdvice weatherAdvice;

    ThunderstormAdvice()
    {
        weatherAdvice = new WeatherAdvice();
    }
    @Override
    public WeatherAdvice setWeatherAdvice(String time) {
        weatherAdvice.setTime(time);
        weatherAdvice.setInfo(THUNDERSTORM_WEATHER_ADVICE);
        return weatherAdvice;
    }
}
