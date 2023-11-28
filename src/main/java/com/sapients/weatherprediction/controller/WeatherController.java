package com.sapients.weatherprediction.controller;

import com.sapients.weatherprediction.model.TemperatureInfo;
import com.sapients.weatherprediction.model.WeatherApiResponse;
import com.sapients.weatherprediction.model.WeatherPredictor;
import com.sapients.weatherprediction.model.WeatherPredictorResponse;
import com.sapients.weatherprediction.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping("/data")
    public ResponseEntity<WeatherPredictorResponse> getWeatherData(@RequestParam String location, @RequestParam String appid, @RequestParam String cnt)
    {
        WeatherPredictorResponse weatherPredictorResponse = new WeatherPredictorResponse();
        weatherPredictorResponse.setStatus(HttpStatus.OK.value());
        weatherPredictorResponse.setData(weatherService.findAll(location,appid,cnt));
        return new ResponseEntity<>(weatherPredictorResponse,HttpStatus.OK);
    }
}
