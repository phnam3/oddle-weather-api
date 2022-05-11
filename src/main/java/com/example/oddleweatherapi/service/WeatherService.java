package com.example.oddleweatherapi.service;

import com.example.oddleweatherapi.dto.WeatherDTO;
import com.example.oddleweatherapi.model.City;
import com.example.oddleweatherapi.repo.WeatherRepository;
import com.example.oddleweatherapi.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

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

    public Weather getOneWeather(Integer id){
        return weatherRepository.findWeatherByCityId(id).get();
    }

    public void addNewWeather(Weather weather) {
        System.out.println(weather);
        weatherRepository.save(weather);
    }

    public void deleteWeather(Integer id){
        weatherRepository.deleteById(id);
    }

    @Transactional
    public void updateWeather(Weather weather, Integer id){
        Weather temp = weatherRepository.findById(id).get();
        temp.setTemp(weather.getTemp());
        temp.setTempMin(weather.getTempMin());
        temp.setTempMax(weather.getTempMax());
        temp.setTodayDate(weather.getTodayDate());
        temp.setCity(weather.getCity());
        temp.setWeatherType(weather.getWeatherType());
    }
}
