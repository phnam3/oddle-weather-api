package com.example.oddleweatherapi.repo;

import com.example.oddleweatherapi.model.WeatherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherTypeRepository extends JpaRepository<WeatherType, Integer> {
}
