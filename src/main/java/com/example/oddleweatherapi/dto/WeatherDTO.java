package com.example.oddleweatherapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDTO {
    private Integer id;

    @NotBlank
    private String temp;

    private String tempMin;
    private String tempMax;
    private String todayDate;
    private String weatherName;
    private String cityName;
    private Integer weatherTypeId;
    private Integer cityId;
}
