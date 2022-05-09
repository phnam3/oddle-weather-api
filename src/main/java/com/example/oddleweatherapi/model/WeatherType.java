package com.example.oddleweatherapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="weather_type")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class WeatherType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="weatherType")
    private String weatherType;

    public WeatherType(Integer id, String weatherType) {
        this.id = id;
        this.weatherType = weatherType;
    }

    public WeatherType(String weatherType) {
        this.weatherType = weatherType;
    }
}
