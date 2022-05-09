package com.example.oddleweatherapi.dto;

import com.example.oddleweatherapi.model.Weather;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherConverter {
    public WeatherDTO entityToDTO(Weather weather){

        WeatherDTO dto = new WeatherDTO();
        dto.setId(weather.getId());
        dto.setTemp(weather.getTemp());
        dto.setTempMax(weather.getTempMax());
        dto.setTempMin(weather.getTempMin());
        dto.setTodayDate(weather.getTodayDate());
//        dto.setCity(?(weather.getCityId()));
//        dto.setWeatherType(?(weather.getWeatherTypeId()));
        return dto;
    }

    public List<WeatherDTO> entityToDTO(List<Weather> weather){

        return weather.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Weather DTOtoEntity(WeatherDTO dto){
        Weather weather = new Weather();
        weather.setId(dto.getId());
        weather.setTemp(dto.getTemp());
        weather.setTempMax(dto.getTempMax());
        weather.setTempMin(dto.getTempMin());
        weather.setTodayDate(dto.getTodayDate());
//        weather.setCity(?(dto.getCityId()));
//        weather.setWeatherType(?(dto.getWeatherTypeId()));
        return weather;
    }

    public List<Weather> DTOtoEntity(List<WeatherDTO> weather){

        return weather.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }

}
