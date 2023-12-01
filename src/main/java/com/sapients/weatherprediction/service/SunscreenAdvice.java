package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherAdvice;

public class SunscreenAdvice implements WeatherAdviceInterface{

    private static final String SUNNY_WEATHER_ADVICE = "Use sunscreen lotion";
    private WeatherAdvice weatherAdvice;

    SunscreenAdvice()
    {
        weatherAdvice = new WeatherAdvice();
    }
    @Override
    public WeatherAdvice setWeatherAdvice(String time) {
        weatherAdvice.setTime(time);
        weatherAdvice.setInfo(SUNNY_WEATHER_ADVICE);
        return weatherAdvice;
    }
}
