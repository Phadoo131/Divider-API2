package com.b9ine.divider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.b9ine.divider.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByRsName(String rsName);

    List<Restaurant> findByCity(String city);
}
