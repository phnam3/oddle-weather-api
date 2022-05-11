package com.example.oddleweatherapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="city")
    private String cityName;

    @OneToMany(mappedBy = "city")
    private List<Weather> weather;

    public City(Integer id) {
        this.id = id;
    }
}
