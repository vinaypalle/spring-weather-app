package com.sapients.weatherprediction.controller;

import com.sapients.weatherprediction.model.WeatherAdviceResponse;
import com.sapients.weatherprediction.model.WeatherPredictorResponse;
import com.sapients.weatherprediction.service.WeatherServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    private WeatherServiceInterface weatherService;
    @Autowired
    public WeatherController(WeatherServiceInterface weatherService)
    {
        this.weatherService = weatherService;
    }
    @GetMapping("/data")
    @Operation(summary = "Get Weather info")
    @ApiResponse(responseCode = "200",description = "Successful operation")
    public ResponseEntity<WeatherPredictorResponse> getWeatherData(@RequestParam String location, @RequestParam String cnt,@RequestHeader String appid)
    {
        logger.info("Fetching weather details of city: {}",location);
        List<WeatherAdviceResponse> weatherAdviceResponseList = weatherService.fetchWeatherInfo(location,appid,cnt);
        WeatherPredictorResponse weatherPredictorResponse = new WeatherPredictorResponse();
        weatherPredictorResponse.setStatus(HttpStatus.OK.value());
        weatherPredictorResponse.setData(weatherAdviceResponseList);
        logger.info("Finished fetching weather details of city: {}",location);
        return new ResponseEntity<>(weatherPredictorResponse,HttpStatus.OK);
    }
}
