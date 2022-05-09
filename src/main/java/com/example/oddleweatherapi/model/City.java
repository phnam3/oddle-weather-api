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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="city")
    private String city;

//    @OneToOne(mappedBy = "city")
//    private Weather weather;

    public City(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public City(String city) {
        this.city = city;
    }
}
