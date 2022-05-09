package com.example.oddleweatherapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDTO {
    private Integer id;
    private String temp;
    private String tempMin;
    private String tempMax;
    private String todayDate;
//    private String weatherType;
//    private String city;
}
