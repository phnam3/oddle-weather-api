package com.example.oddleweatherapi;

import com.example.oddleweatherapi.model.Weather;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Bean
    CommandLineRunner commandLineRunner(WeatherRepository repository){
        return args -> {
            Weather weather1 = new Weather(1, "25C", "15C", "30C",
                    "2022-01-01", 1, 1);
            Weather weather2 = new Weather("27C", "17C", "32C",
                    "2022-01-01", 2, 2);
//            repository.save(weather1);
//            repository.save(weather2);
        };
    }
}
