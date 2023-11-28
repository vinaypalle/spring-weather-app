package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.TemperatureInfo;
import com.sapients.weatherprediction.model.WeatherAdvice;
import com.sapients.weatherprediction.model.WeatherData;
import com.sapients.weatherprediction.model.WeatherPredictor;

import java.util.*;

public class BasicTemperatureInfo implements WeatherInfo {

    private static final String RAIN_WEATHER_ADVICE = "Carry an umbrella";

    private static final String SUNNY_WEATHER_ADVICE = "Use sunscreen lotion";
    @Override
        public List<WeatherPredictor> findWeatherInfo(Map<String, List<WeatherData>> weatherMap)
        {
            List<WeatherPredictor> temperatureInfoList = new ArrayList<>();
            for(Map.Entry<String, List<WeatherData>> entry:weatherMap.entrySet())
            {
                double minTemp = Double.MAX_VALUE;
                double maxTemp = Double.MIN_VALUE;
                boolean rain = false;
                boolean sunny = false;
                List<String> rainTime = new ArrayList<>();
                List<String> sunnyTime = new ArrayList<>();
                List<WeatherAdvice> weatherAdviceList = new ArrayList<>();

                for(WeatherData curr : entry.getValue())
                {
                    minTemp = Math.min(minTemp,curr.getMainInfo().getTempMin());
                    maxTemp = Math.max(maxTemp,curr.getMainInfo().getTempMax());
                    if(curr.getWeatherInfoList().get(0).getMain().equals("Rain"))
                    {
                        rain = true;
                        rainTime.add(curr.getDtTxt().substring(11,19));
                    }
                    if(maxTemp-273.15 > 40)
                    {
                        sunny = true;
                        sunnyTime.add(curr.getDtTxt().substring(11,19));
                    }
                }
                TemperatureInfo temperatureInfo = new TemperatureInfo();
                temperatureInfo.setMinTemp(minTemp);
                temperatureInfo.setMaxTemp(maxTemp);

                if(rain)
                {
                    WeatherAdvice weatherAdvice = new WeatherAdvice();
                    weatherAdvice.setInfo(RAIN_WEATHER_ADVICE);
                    weatherAdvice.setTime(rainTime);
                    weatherAdviceList.add(weatherAdvice);
                }
                if(sunny)
                {
                    WeatherAdvice weatherAdvice = new WeatherAdvice() ;
                    weatherAdvice.setInfo(SUNNY_WEATHER_ADVICE);
                    weatherAdvice.setTime(rainTime);
                    weatherAdviceList.add(weatherAdvice);
                }
                temperatureInfo.setWeatherAdvice(weatherAdviceList);
                temperatureInfo.setDate(entry.getKey());
                temperatureInfoList.add(temperatureInfo);
            }
            return temperatureInfoList;
        }
}
