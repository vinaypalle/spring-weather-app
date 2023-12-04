# Springboot Weather App
The Weather Information Application is a Spring Boot based service designed to provide weather information and related advice based on data obtained from the [Openweathermap](https://openweathermap.org) API. The application offers insights and recommendations based on various weather conditions to assist users in making informed decisions before stepping out.




## Features

- Weather Information: Provides current weather details fetched from OpenWeatherMap.
- Advice Generation: Offers advice tailored to different weather conditions.
- Modularity: Highly modular and extensible design for easy addition of new weather conditions.
- Robustness: Comprehensive exception handling throughout the application.
- Design Patterns: Utilizes the Factory design pattern for flexibility in incorporating new weather conditions.
- Service Architecture: Implements services, interfaces, and models to segregate concerns


## Tech Stack

Server: Java 17, Spring boot

DevOps: Github Actions, Docker


## Run Locally

### Linux
```bash
docker pull pvkr/spring-weather-prediction:latest
```

### Windows & Mac

- Clone the project
```bash
git clone https://link-to-project
```

- Go to the project directory
```bash
cd my-project
```
- Start the server
```bash
mvn clean install run
```
Note: Make sure the target system has maven or supported IDE installed
## Functionality

### Request Handling

- Controller: Captures incoming requests and analyzes their parameters.
- Validation: Checks for missing parameters and throws exceptions if any are absent.
- Response Generation: Retrieves weather information from the OpenWeatherMap provider if parameters are valid and returns the processed result.

### Components

- Services: Houses the business logic, including WeatherAdvice models and WeatherService.
- Interfaces: Utilized wherever necessary to maintain abstraction and facilitate extensibility.
- Models: Represents various entities, such as WeatherAdvice models, to structure and manage data.

### Design Pattern
- Utilizes the Factory design pattern for flexibility in incorporating new weather conditions.
### Logging

- Logger Usage: Implemented logging mechanisms for crucial processes, including fetching weather information and mapping weather data to models.


### Application Flow

- Flowchart: Includes a visual representation of the application's workflow to aid in understanding the sequence of operations and interactions between components.
## Documentation

- Swagger API: Employs Swagger to automatically generate API documentation, ensuring clarity and ease of understanding the available endpoints and functionalities.

  [Documentation](/assets/api-documentation.pdf)

## Usage/Examples
weather/data?location=London&cnt=30

<details><summary>Output</summary><p>

```json
{
"status": 200,
"data": [
{
"minTemp": 277.52,
"maxTemp": 279.16,
"weatherAdvice": [
{
"info": "Carry an umbrella",
"time": "00:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "00:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "03:00:00"
},
{
"info": "Carry an umbrella",
"time": "06:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "06:00:00"
},
{
"info": "Carry an umbrella",
"time": "09:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "09:00:00"
},
{
"info": "Carry an umbrella",
"time": "12:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "12:00:00"
},
{
"info": "Carry an umbrella",
"time": "15:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "15:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "18:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "21:00:00"
}
],
"date": "2023-12-05"
},
{
"minTemp": 275.79,
"maxTemp": 278.18,
"weatherAdvice": [
{
"info": "It's too windy, watch out!",
"time": "00:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "03:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "06:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "09:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "12:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "15:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "18:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "21:00:00"
}
],
"date": "2023-12-06"
},
{
"minTemp": 279.2,
"maxTemp": 279.88,
"weatherAdvice": [
{
"info": "It's too windy, watch out!",
"time": "00:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "03:00:00"
},
{
"info": "Carry an umbrella",
"time": "06:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "06:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "09:00:00"
},
{
"info": "Carry an umbrella",
"time": "12:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "12:00:00"
},
{
"info": "Carry an umbrella",
"time": "15:00:00"
},
{
"info": "It's too windy, watch out!",
"time": "15:00:00"
}
],
"date": "2023-12-07"
}
]
}
```
</p>
</details>

## Screenshots

![Factory Design Pattern](/assets/factory-design-pattern.png?raw=true "Factory Design Pattern")

![Flowchart](/assets/spring-boot-weather-app.drawio.png?raw=true "Flowchart")


## Authors

- [@vinaypalle](https://github.com/vinaypalle)


## Conclusion

The Weather Information Application stands out for its robustness, modularity, and adherence to best practices in software development. By leveraging [Openweathermap](https://openweathermap.org) data and employing well-defined architecture, it provides users with valuable insights and recommendations tailored to prevailing weather conditions.