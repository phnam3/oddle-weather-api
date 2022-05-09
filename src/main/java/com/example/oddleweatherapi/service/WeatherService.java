package com.example.oddleweatherapi.service;

import com.example.oddleweatherapi.WeatherRepository;
import com.example.oddleweatherapi.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    public void addNewWeather(Weather weather) {
        Optional<Weather> weatherOptional = weatherRepository.findWeatherByCityId(weather.getCityId());
        if(weatherOptional.isPresent()){
            throw new IllegalStateException("City Already Existed");
        }
        weatherRepository.save(weather);
    }

    public void deleteWeather(Integer id){
        boolean exists = weatherRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Weather Id  " + id + " does not exist");
        }
        weatherRepository.deleteById(id);
    }

    @Transactional
    public void updateWeather(Integer id, String temp, String tempMin,
                              String tempMax, String todayDate, Integer weatherTypeId, Integer cityId){
        Weather weather = weatherRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Weather ID " + id + " not exist"));

        if(temp != null && temp.length() > 0 &&
        !Objects.equals(weather.getTemp(), temp)){
            weather.setTemp(temp);
        }

        if(tempMin != null && tempMin.length() > 0 &&
        !Objects.equals(weather.getTempMin(), tempMin)){
            weather.setTempMin(tempMin);
        }

        if(tempMax != null && tempMax.length() > 0 &&
        !Objects.equals(weather.getTempMax(), tempMax)){
            weather.setTempMax(tempMax);
        }

        if(todayDate != null && todayDate.length() > 0 &&
                !Objects.equals(weather.getTodayDate(), todayDate)){
            weather.setTodayDate(todayDate);
        }

        if(weatherTypeId != null && weatherTypeId > 0 &&
                !Objects.equals(weather.getWeatherTypeId(), weatherTypeId)){
            weather.setWeatherTypeId(weatherTypeId);
        }

        if(cityId != null && cityId > 0 &&
                !Objects.equals(weather.getCityId(), cityId)){
            weather.setCityId(cityId);
            Optional<Weather> weatherOptional = weatherRepository.findWeatherByCityId(weather.getCityId());
            if(weatherOptional.isPresent()){
                throw new IllegalStateException("City Already Existed");
            }
            weather.setCityId(cityId);
        }
    }
}
