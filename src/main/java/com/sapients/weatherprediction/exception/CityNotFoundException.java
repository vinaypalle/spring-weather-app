package com.sapients.weatherprediction.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String s)
    {
        super(s);
    }
}
