package com.sapients.weatherprediction.controller;

import com.sapients.weatherprediction.model.WeatherAdviceResponse;
import com.sapients.weatherprediction.model.WeatherPredictorResponse;
import com.sapients.weatherprediction.service.WeatherService;
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
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/data")
    @Operation(summary = "Get Weather info")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Successful operation"),
            @ApiResponse(responseCode = "401",description = "Unauthorized"),
            @ApiResponse(responseCode = "404",description = "City not found"),
            @ApiResponse(responseCode = "429",description = "Too many requests"),
            @ApiResponse(responseCode = "500",description = "Internal server error")
    })
    public ResponseEntity<WeatherPredictorResponse> getWeatherData(@RequestParam String location, @RequestParam String cnt,@RequestHeader String appid)
    {
        logger.info("Fetching weather details of city: {}",location);
        List<WeatherAdviceResponse> weatherAdviceResponseList = weatherService.findAll(location,appid,cnt);
        WeatherPredictorResponse weatherPredictorResponse = new WeatherPredictorResponse();
        weatherPredictorResponse.setStatus(HttpStatus.OK.value());
        weatherPredictorResponse.setData(weatherAdviceResponseList);
        logger.info("Finished fetching weather details of city: {}",location);
        return new ResponseEntity<>(weatherPredictorResponse,HttpStatus.OK);
    }
}
