package com.vidya.crud.controllers;

import com.vidya.crud.models.GeoLocation;
import com.vidya.crud.req.City;
import com.vidya.crud.res.WeatherResponse;
import com.vidya.crud.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/")
public class WeatherController {
	
	@Autowired
	private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/your-location")
    public ResponseEntity<WeatherResponse> getWeather(@RequestBody GeoLocation geoLocation) {
        double lat = geoLocation.getLat();
        double lon = geoLocation.getLon();
        WeatherResponse weatherResponse = weatherService.getCurrentWeather(lat, lon);
        
        if (weatherResponse != null) {
            return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/test")
    public ResponseEntity<String> getWeather() {

        return new ResponseEntity<>("weatherResponse", HttpStatus.OK);
    }
    
    @PostMapping("/by-city-id")
    public ResponseEntity<WeatherResponse> getWeatherByCityId(@RequestBody City city) {
    	long cityId = city.getCityId();
        WeatherResponse weatherResponse = weatherService.getCurrentWeatherByCityId(cityId);

        if (weatherResponse != null) {
            return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    
}
