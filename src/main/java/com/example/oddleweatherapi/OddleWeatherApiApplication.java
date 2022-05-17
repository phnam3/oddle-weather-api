package com.example.oddleweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
public class OddleWeatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OddleWeatherApiApplication.class, args);
    }

}
