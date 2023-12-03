package com.sapients.weatherprediction.controller;

import com.sapients.weatherprediction.model.TemperatureInfo;
import com.sapients.weatherprediction.model.WeatherPredictorResponse;
import com.sapients.weatherprediction.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private static Logger logger = LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/data")
    public ResponseEntity<WeatherPredictorResponse> getWeatherData(@RequestParam String location, @RequestParam String cnt,@RequestHeader String appid)
    {
        logger.info("Starting to get weather data");
        List<TemperatureInfo> temperatureInfoList = weatherService.findAll(location,appid,cnt);
        WeatherPredictorResponse weatherPredictorResponse = new WeatherPredictorResponse();
        weatherPredictorResponse.setStatus(HttpStatus.OK.value());
        weatherPredictorResponse.setData(temperatureInfoList);
        logger.info("Completed getting the weather data");
        return new ResponseEntity<>(weatherPredictorResponse,HttpStatus.OK);
    }
}
