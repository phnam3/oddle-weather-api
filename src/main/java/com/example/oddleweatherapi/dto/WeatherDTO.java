package com.example.oddleweatherapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDTO {
    //TODO: NotBlank -> Validation String Boot
    private Integer id;

    @NotBlank
    private String temp;

    private String tempMin;
    private String tempMax;
    private String todayDate;
//    private String weatherType1;
//    private String city1;
    private Integer weatherType;
    private Integer city;
}
