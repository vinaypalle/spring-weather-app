package com.sapients.weatherprediction.service;

public class WeatherFactory {

    public static WeatherAdviceInterface getWeatherAdviceInterface(String adviceType)
    {
        WeatherAdviceInterface weatherAdviceInterface = null;

        if(adviceType.equals("rain"))
        {
            weatherAdviceInterface = new RainAdvice();
        }
        else if(adviceType.equals("sunny"))
        {
            weatherAdviceInterface = new SunscreenAdvice();
        }
        else if(adviceType.equals("wind"))
        {
            weatherAdviceInterface = new WindAdvice();
        }
        else if(adviceType.equals("thunderstorm"))
        {
            weatherAdviceInterface = new ThunderstormAdvice();
        }
        return weatherAdviceInterface;
    }
}
