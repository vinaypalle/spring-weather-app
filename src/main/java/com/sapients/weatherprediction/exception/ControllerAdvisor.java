package com.sapients.weatherprediction.exception;

import com.sapients.weatherprediction.model.ErrorResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    @ApiResponse(responseCode = "404",description = "City not found")
    public ResponseEntity<ErrorResponse> handleCityNotFoundException(CityNotFoundException exception)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage("City not found");
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiKeyException.class)
    @ApiResponse(responseCode = "401",description = "Unauthorized")
    public ResponseEntity<ErrorResponse> handleApiKeyException(ApiKeyException exception)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setMessage("Invalid API key");
        return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TooManyRequestsException.class)
    @ApiResponse(responseCode = "429",description = "Too many requests")
    public ResponseEntity<ErrorResponse> handleTooManyRequestsException(TooManyRequestsException exception)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        errorResponse.setMessage("Too many requests");
        return new ResponseEntity<>(errorResponse,HttpStatus.TOO_MANY_REQUESTS);
    }
    @ExceptionHandler(ServerException.class)
    @ApiResponse(responseCode = "500",description = "Internal server error")
    public ResponseEntity<ErrorResponse> handleServerException(ServerException exception)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage("Internal Server Error");
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
