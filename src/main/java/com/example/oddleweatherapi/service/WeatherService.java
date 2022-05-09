package com.example.oddleweatherapi.service;

import com.example.oddleweatherapi.WeatherRepository;
import com.example.oddleweatherapi.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
    public List<Weather> getWeather(){
        return weatherRepository.findAll();
    }
}
