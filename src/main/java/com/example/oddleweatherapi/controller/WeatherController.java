package com.example.oddleweatherapi.controller;

import com.example.oddleweatherapi.dto.WeatherConverter;
import com.example.oddleweatherapi.dto.WeatherDTO;
import com.example.oddleweatherapi.mapper.WeatherMapper;
import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.service.WeatherService;
import org.mapstruct.factory.Mappers;
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
    private final WeatherMapper weatherMapper = Mappers.getMapper(WeatherMapper.class);

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherConverter weatherConverter) {
        this.weatherService = weatherService;
        this.weatherConverter = weatherConverter;
    }

    @GetMapping
    public ResponseEntity<List<WeatherDTO>> getAllWeather() {
        List<Weather> findAll = weatherService.getWeather();
        List<WeatherDTO> weatherDTOs = weatherMapper.ListEntityToListDTO(findAll);
        return ResponseEntity.ok().body(weatherDTOs);
    }

    @GetMapping(path = "{cityId}")
    public ResponseEntity<WeatherDTO> getOneWeatherByCityId(@PathVariable("cityId") Integer cityId){
        Weather findOne = weatherService.getOneWeather(cityId);
        WeatherDTO weatherDTO = weatherMapper.entityToDTO(findOne);
        return ResponseEntity.ok().body(weatherDTO);
    }

    @PostMapping
    public void registerNewWeather(@RequestBody @Valid WeatherDTO weatherDTO){
        Weather weather = weatherMapper.DTOtoEntity(weatherDTO);
        weatherService.addNewWeather(weather);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWeather(@PathVariable("id") Integer id){
        weatherService.deleteWeather(id);
    }

    @PutMapping(path = "{id}")
    public void updateWeather(@PathVariable("id") Integer id, @RequestBody @Valid WeatherDTO weatherDTO){
        Weather weather = weatherMapper.DTOtoEntity(weatherDTO);
        weatherService.updateWeather(weather,id);
    }

}
