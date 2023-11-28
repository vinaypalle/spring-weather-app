package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherApiResponse;
import com.sapients.weatherprediction.model.WeatherData;
import com.sapients.weatherprediction.model.WeatherPredictor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Value("${uri}")
    private String baseUri;

    private String buildApiUrl(String location,String appid,String cnt) {
        return baseUri + "?q={location}&appid={appid}&cnt={cnt}";
    }
    public List<WeatherPredictor> findAll(String location, String appid, String cnt) throws RestClientException
    {
        String uri = buildApiUrl(location,appid,cnt);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("location", location);
        uriVariables.put("appid",appid);
        uriVariables.put("cnt", cnt);
        ResponseEntity<WeatherApiResponse> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, WeatherApiResponse.class, uriVariables);
        WeatherApiResponse weatherApiResponse = response.getBody();
        Map<String, List<WeatherData>> weatherMap = weatherApiResponse.getList().stream().collect(Collectors.groupingBy(weatherData->weatherData.getDtTxt().substring(0,10)));

        WeatherInfo temperatureInfo = new BasicTemperatureInfo();
        List<WeatherPredictor> temperatureInfoList = temperatureInfo.findWeatherInfo(weatherMap);
        return temperatureInfoList;
    }
}
