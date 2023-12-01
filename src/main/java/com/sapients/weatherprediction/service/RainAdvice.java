package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherAdvice;

public class RainAdvice implements WeatherAdviceInterface{

    private static final String RAIN_WEATHER_ADVICE = "Carry an umbrella";
    private WeatherAdvice weatherAdvice;

    RainAdvice()
    {
        weatherAdvice = new WeatherAdvice();
    }
    @Override
    public WeatherAdvice setWeatherAdvice(String time) {
        weatherAdvice.setTime(time);
        weatherAdvice.setInfo(RAIN_WEATHER_ADVICE);
        return weatherAdvice;
    }
}
