package com.example.oddleweatherapi.controller;

import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<List<Weather>> getAllWeather() {
        return ResponseEntity.ok().body(weatherService.getWeather());
    }

    @GetMapping(path = "{cityId}")
    public ResponseEntity<Weather> getOneWeatherByCityId(@PathVariable("cityId") Integer cityId){
        return ResponseEntity.ok().body(weatherService.getOneWeather(cityId));
    }

    //dto FE -> weather dto,  POJO obj -> weather
    //backend process dto -> Weather -> req -> database

    @PostMapping
    public void registerNewWeather(@RequestBody Weather weather){
        weatherService.addNewWeather(weather);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWeather(@PathVariable("id") Integer id){
        weatherService.deleteWeather(id);
    }

    @PutMapping(path = "{id}")
    public void updateWeather(@PathVariable("id") Integer id,
                              @RequestParam String temp,
                              @RequestParam(required = false) String tempMin,
                              @RequestParam(required = false) String tempMax,
                              @RequestParam(required = false) String todayDate,
                              @RequestParam Integer weatherTypeId,
                              @RequestParam Integer cityId){
        weatherService.updateWeather(id, temp, tempMin, tempMax, todayDate, weatherTypeId, cityId);
    }

}
