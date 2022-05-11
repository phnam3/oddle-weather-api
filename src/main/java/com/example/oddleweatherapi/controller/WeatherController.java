package com.example.oddleweatherapi.controller;

import com.example.oddleweatherapi.dto.WeatherDTO;
import com.example.oddleweatherapi.mapper.WeatherMapper;
import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="api/weather")
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper = Mappers.getMapper(WeatherMapper.class);

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<List<WeatherDTO>> getAllWeather() {
        log.info("Getting All Weather");
        List<Weather> findAll = weatherService.getWeather();
        List<WeatherDTO> weatherDTOs = weatherMapper.ListEntityToListDTO(findAll);
        return ResponseEntity.ok().body(weatherDTOs);
    }

    @GetMapping(path = "{cityId}")
    public ResponseEntity<WeatherDTO> getOneWeatherByCityId(@PathVariable("cityId") Integer cityId){
        log.info("Getting Weather based on City ID ");
        Weather findOne = weatherService.getOneWeather(cityId);
        WeatherDTO weatherDTO = weatherMapper.entityToDTO(findOne);
        return ResponseEntity.ok().body(weatherDTO);
    }

    @PostMapping
    public void registerNewWeather(@RequestBody @Valid WeatherDTO weatherDTO){
        log.info("Add New Weather Entity");
        Weather weather = weatherMapper.DTOtoEntity(weatherDTO);
        weatherService.addNewWeather(weather);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWeather(@PathVariable("id") Integer id){
        log.info("Delete Weather based on Weather ID");
        weatherService.deleteWeather(id);
    }

    @PutMapping(path = "{id}")
    public void updateWeather(@PathVariable("id") Integer id, @RequestBody @Valid WeatherDTO weatherDTO){
        log.info("Update Weather based on Weather ID");
        Weather weather = weatherMapper.DTOtoEntity(weatherDTO);
        weatherService.updateWeather(weather,id);
    }

}
