package com.example.oddleweatherapi.config;

import com.example.oddleweatherapi.repo.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Bean
    CommandLineRunner commandLineRunner(WeatherRepository repository){
        return args -> {
        };
    }
}
