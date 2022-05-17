package com.example.oddleweatherapi.mapper;

import com.example.oddleweatherapi.dto.WeatherDTO;
import com.example.oddleweatherapi.model.City;
import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.model.WeatherType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface WeatherMapper {
    default City mapCity(WeatherDTO weatherDTO){
        return new City(weatherDTO.getCityId());
    }
    default WeatherType mapWeather(WeatherDTO weatherDTO){
        return new WeatherType(weatherDTO.getWeatherTypeId());
    }

    @Mapping(source = "weather.city.cityName", target = "cityName")
    @Mapping(source = "weather.weatherType.weatherTypeName", target = "weatherName")
    WeatherDTO entityToDTO(Weather weather);

    @Mapping(target = "city", expression = "java(mapCity(weatherDTO))")
    @Mapping(target = "weatherType", expression = "java(mapWeather(weatherDTO))")
    Weather DTOtoEntity(WeatherDTO weatherDTO);

    List<WeatherDTO> ListEntityToListDTO(List<Weather> weather);
    List<Weather> ListDTOtoListEntity(List<WeatherDTO> weather);
}
