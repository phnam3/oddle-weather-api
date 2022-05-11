package com.example.oddleweatherapi.controller;

import com.example.oddleweatherapi.dto.WeatherConverter;
import com.example.oddleweatherapi.dto.WeatherDTO;
import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="api/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherConverter weatherConverter;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherConverter weatherConverter) {
        this.weatherService = weatherService;
        this.weatherConverter = weatherConverter;
    }

    @GetMapping
    public ResponseEntity<List<WeatherDTO>> getAllWeather() {
        List<Weather> findAll = weatherService.getWeather();
        return ResponseEntity.ok().body(weatherConverter.entityToDTO(findAll));
    }

    @GetMapping(path = "{cityId}")
    public ResponseEntity<WeatherDTO> getOneWeatherByCityId(@PathVariable("cityId") Integer cityId){
        Weather findOne = weatherService.getOneWeather(cityId);
        return ResponseEntity.ok().body(weatherConverter.entityToDTO(findOne));
    }

    @PostMapping
    public void registerNewWeather(@RequestBody @Valid WeatherDTO weatherDTO){
        Weather weather = weatherConverter.DTOtoEntity(weatherDTO);
        weatherService.addNewWeather(weather);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWeather(@PathVariable("id") Integer id){
        weatherService.deleteWeather(id);
    }

    @PutMapping
    public void updateWeather(@RequestBody @Valid WeatherDTO weatherDTO){
        Weather weather = weatherConverter.DTOtoEntity(weatherDTO);
        weatherService.updateWeather(weather);
    }

}
