package com.example.oddleweatherapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="weather_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="weatherType")
    private String weatherType;

    @OneToMany(mappedBy = "weatherType", cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    private List<Weather> weather;

    public WeatherType(Integer id) {
        this.id = id;
    }
    public WeatherType(String weatherType){
        this.weatherType = weatherType;
    }
}
