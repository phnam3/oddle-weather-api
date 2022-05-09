package com.example.oddleweatherapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="weather")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEMP")
    private String temp;
    @Column(name = "TEMP_MIN")
    private String tempMin;
    @Column(name = "TEMP_MAX")
    private String tempMax;
    @Column(name = "TODAY_DATE")
    private String todayDate;
    @Column(name = "WEATHER_TYPE_ID")
    private Integer weatherTypeId;
    @Column(name = "CITY_ID")
    private Integer cityId;

    public Weather(Integer id, String temp, String tempMin, String tempMax, String todayDate, Integer weatherTypeId, Integer cityId) {
        this.id = id;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.todayDate = todayDate;
        this.weatherTypeId = weatherTypeId;
        this.cityId = cityId;
    }

    public Weather(String temp, String tempMin, String tempMax, String todayDate, Integer weatherTypeId, Integer cityId) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.todayDate = todayDate;
        this.weatherTypeId = weatherTypeId;
        this.cityId = cityId;
    }
}
