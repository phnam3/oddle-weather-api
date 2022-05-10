package com.example.oddleweatherapi.config;

import com.example.oddleweatherapi.model.City;
import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.model.WeatherType;
import com.example.oddleweatherapi.repo.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeatherConfig {

    //TODO: implement with liquidbase to create table and insert sample data for city, weathertype,
    //sample weather
    @Bean
    CommandLineRunner commandLineRunner(WeatherRepository repository){
        return args -> {
            City c1 = new City(2);
            WeatherType wt1 = new WeatherType(1);
            Weather weather1 = new Weather("25C", "15C", "30C",
                    "2022-01-01", wt1, c1);

            City c2 = new City(3);
            WeatherType wt2 = new WeatherType(2);
            Weather weather2 = new Weather("255C", "155C", "305C",
                    "2022-01-01", wt2, c2);

            repository.saveAll(List.of(weather1, weather2));
        };
    }
}
