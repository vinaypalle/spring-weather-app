package com.sapients.weatherprediction.controller;

import com.sapients.weatherprediction.model.WeatherApiResponse;
import com.sapients.weatherprediction.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping("/data")
    public WeatherApiResponse getWeatherData(@RequestParam String location, @RequestParam String appid, @RequestParam String cnt)
    {
        return weatherService.findAll(location,appid,cnt);
    }
}
