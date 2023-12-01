package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherAdvice;

public class WindAdvice implements WeatherAdviceInterface{

    private static final String WIND_WEATHER_ADVICE = "It's too windy, watch out!";
    private WeatherAdvice weatherAdvice;

    WindAdvice()
    {
        weatherAdvice = new WeatherAdvice();
    }
    @Override
    public WeatherAdvice setWeatherAdvice(String time) {
        weatherAdvice.setTime(time);
        weatherAdvice.setInfo(WIND_WEATHER_ADVICE);
        return weatherAdvice;
    }
}
