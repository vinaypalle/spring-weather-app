package com.sapients.weatherprediction.exception;

public class TooManyRequestsException extends RuntimeException{

    public TooManyRequestsException(String s)
    {
        super(s);
    }
}
