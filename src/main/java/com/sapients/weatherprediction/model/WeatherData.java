package com.sapients.weatherprediction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    private long dt;
    @JsonProperty("main")
    private MainInfo mainInfo;
    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfoList;
    @JsonProperty("clouds")
    private CloudsInfo cloudsInfo;
    @JsonProperty("wind")
    private WindInfo windInfo;
    private int visibility;
    private int pop;
    @JsonProperty("sys")
    private SysInfo sysInfo;
    @JsonProperty("dt_txt")
    private String dtTxt;
}
