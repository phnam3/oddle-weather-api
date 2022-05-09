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
    @Column(name = "WEATHER_TYPE_ID", nullable = false)
    private Integer weatherTypeId;
    @Column(name = "CITY_ID", nullable = false)
    private Integer cityId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "WEATHER_TYPE_ID", referencedColumnName = "id")
//    private WeatherType weatherType;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cityIdtesting", referencedColumnName = "id")
//    private City city;

    public Weather(String temp, String tempMin, String tempMax, String todayDate, Integer weatherTypeId, Integer cityId) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.todayDate = todayDate;
        this.weatherTypeId = weatherTypeId;
        this.cityId = cityId;
    }
}
