package com.example.oddleweatherapi.Config;

import com.example.oddleweatherapi.model.Weather;
import com.example.oddleweatherapi.repo.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeatherConfig {

    @Bean
    CommandLineRunner commandLineRunner(WeatherRepository repository){
        return args -> {
            Weather weather1 = new Weather("25C", "15C", "30C",
                    "2022-01-01", 1, 1);
            Weather weather2 = new Weather("27C", "17C", "32C",
                    "2022-01-01", 2, 2);

            repository.saveAll(List.of(weather1, weather2));
        };
    }
}
