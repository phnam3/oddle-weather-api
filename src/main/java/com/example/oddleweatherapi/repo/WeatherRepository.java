package com.example.oddleweatherapi.repo;

import com.example.oddleweatherapi.model.City;
import com.example.oddleweatherapi.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    Optional<Weather> findWeatherByCityId(Integer cityId);
//    Optional<Weather> findWeatherByCity(City city);
//    Optional<City> findCityByCityId(Integer cityId);


}
