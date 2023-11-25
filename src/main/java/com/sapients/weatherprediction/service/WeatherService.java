package com.sapients.weatherprediction.service;

import com.sapients.weatherprediction.model.WeatherApiResponse;
import com.sapients.weatherprediction.model.WeatherData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    public WeatherApiResponse findAll(String location, String appid, String cnt) throws RestClientException
    {
        final String uri = "https://api.openweathermap.org/data/2.5/forecast?q={location}&appid={appid}&cnt={cnt}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("location", location);
        uriVariables.put("appid",appid);
        uriVariables.put("cnt", cnt);
        ResponseEntity<WeatherApiResponse> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, WeatherApiResponse.class, uriVariables);
        WeatherApiResponse weatherApiResponse = response.getBody();
        return response.getBody();
    }
}
