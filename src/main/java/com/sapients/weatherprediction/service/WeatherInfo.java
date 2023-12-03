package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.TemperatureInfo;
import com.sapients.weatherprediction.model.WeatherAdvice;
import com.sapients.weatherprediction.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class WeatherInfo implements WeatherInfoInterface {

    private static Logger logger = LoggerFactory.getLogger(WeatherInfo.class);
    @Override
        public List<TemperatureInfo> findWeatherInfo(Map<String, List<WeatherData>> weatherMap)
        {
            List<TemperatureInfo> temperatureInfoList = new ArrayList<>();
            logger.info("Preparing weather advice for each day");
            for(Map.Entry<String, List<WeatherData>> entry:weatherMap.entrySet())
            {
                double minTemp = Double.MAX_VALUE;
                double maxTemp = Double.MIN_VALUE;
                List<WeatherAdvice> weatherAdviceList = new ArrayList<>();

                for(WeatherData curr : entry.getValue())
                {
                    minTemp = Math.min(minTemp,curr.getMainInfo().getTempMin());
                    maxTemp = Math.max(maxTemp,curr.getMainInfo().getTempMax());
                    if(curr.getWeatherInfoList().get(0).getMain().equals("Rain"))
                    {
                        WeatherAdviceInterface weatherAdviceInterface = WeatherFactory.getWeatherAdviceInterface("rain");
                        weatherAdviceList.add(weatherAdviceInterface.setWeatherAdvice(curr.getDtTxt().substring(11,19)));
                    }
                    if(maxTemp-273.15 > 40)
                    {
                        WeatherAdviceInterface weatherAdviceInterface = WeatherFactory.getWeatherAdviceInterface("sunny");
                        weatherAdviceList.add(weatherAdviceInterface.setWeatherAdvice(curr.getDtTxt().substring(11,19)));
                    }
                    if(curr.getWindInfo().getSpeed() > 0.0027777778)
                    {
                        WeatherAdviceInterface weatherAdviceInterface = WeatherFactory.getWeatherAdviceInterface("wind");
                        weatherAdviceList.add(weatherAdviceInterface.setWeatherAdvice(curr.getDtTxt().substring(11,19)));
                    }
                    if(curr.getWeatherInfoList().get(0).getMain().equals("Thunderstorm"))
                    {
                        WeatherAdviceInterface weatherAdviceInterface = WeatherFactory.getWeatherAdviceInterface("rain");
                        weatherAdviceList.add(weatherAdviceInterface.setWeatherAdvice(curr.getDtTxt().substring(11,19)));
                    }
                }
                TemperatureInfo temperatureInfo = new TemperatureInfo();
                temperatureInfo.setMinTemp(minTemp);
                temperatureInfo.setMaxTemp(maxTemp);
                temperatureInfo.setWeatherAdvice(weatherAdviceList);
                temperatureInfo.setDate(entry.getKey());
                temperatureInfoList.add(temperatureInfo);
            }
            logger.info("Finished getting the weather advice for each day");
            return temperatureInfoList;
        }
}
