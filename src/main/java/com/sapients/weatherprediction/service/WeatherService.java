package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.exception.ApiKeyException;
import com.sapients.weatherprediction.exception.CityNotFoundException;
import com.sapients.weatherprediction.exception.ServerException;
import com.sapients.weatherprediction.exception.TooManyRequestsException;
import com.sapients.weatherprediction.model.TemperatureInfo;
import com.sapients.weatherprediction.model.WeatherApiResponse;
import com.sapients.weatherprediction.model.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Value("${uri}")
    private String baseUri;

    private static Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private String buildApiUrl(String location,String appid,String cnt) {
        return baseUri + "?q={location}&appid={appid}&cnt={cnt}";
    }
    public List<TemperatureInfo> findAll(String location, String appid, String cnt) throws RestClientException
    {
        logger.info("building api url");
        String uri = buildApiUrl(location,appid,cnt);
        logger.info("Finished api url building");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("location", location);
        uriVariables.put("appid",appid);
        uriVariables.put("cnt", cnt);
        ResponseEntity<WeatherApiResponse> response;
        try{
            logger.info("sending request to openweathermap");
            response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, WeatherApiResponse.class, uriVariables);
        }
        catch(HttpClientErrorException exception)
        {
            if(exception.getStatusCode() == HttpStatus.UNAUTHORIZED)
            {
                logger.error("Unauthorized exception");
                throw new ApiKeyException(exception.getMessage());
            }
            else if(exception.getStatusCode() == HttpStatus.NOT_FOUND)
            {
                logger.error("City not found exception");
                throw new CityNotFoundException(exception.getMessage());
            }
            else if(exception.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS)
            {
                logger.error("Too many requests exception");
                throw new TooManyRequestsException(exception.getMessage());
            }
            else {
                logger.error("Unexpected error found");
                throw new RuntimeException();
            }
        }
        catch(HttpServerErrorException exception)
        {
            logger.error("Server side exception");
            throw new ServerException(exception.getMessage());
        }
        WeatherApiResponse weatherApiResponse = response.getBody();
        Map<String, List<WeatherData>> weatherMap = weatherApiResponse.getList().stream().collect(Collectors.groupingBy(weatherData->weatherData.getDtTxt().substring(0,10)));

        WeatherInfoInterface weatherInfo = new WeatherInfo();
        logger.info("Initializing weatherinfo model");
        List<TemperatureInfo> weatherInfoList = weatherInfo.findWeatherInfo(weatherMap);
        logger.info("Finished mapping weatherinfo");
        return weatherInfoList;
    }
}
