package com.b9ine.divider.repository;

import com.b9ine.divider.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {
    City findByCityName(String cityName);

    List<City> findByCityNameContainingIgnoreCase(String cityName);
}
