package com.example.oddleweatherapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="weather")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEMP", nullable = false)
    private String temp;
    @Column(name = "TEMP_MIN")
    private String tempMin;
    @Column(name = "TEMP_MAX")
    private String tempMax;
    @Column(name = "TODAY_DATE")
    private String todayDate;

    @ManyToOne
    @JoinColumn(name="CITY_ID", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name="WEATHER_TYPE_ID", nullable = false)
    private WeatherType weatherType;

    public Weather(String temp, String tempMin, String tempMax, String todayDate, WeatherType weatherType, City city) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.todayDate = todayDate;
        this.weatherType = weatherType;
        this.city = city;
    }

}
