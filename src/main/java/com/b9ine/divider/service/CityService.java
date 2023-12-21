package com.b9ine.divider.service;

import com.b9ine.divider.exception.DataAlreadyAddedException;
import com.b9ine.divider.exception.DataNotFoundException;
import com.b9ine.divider.model.City;
import com.b9ine.divider.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(String cityId) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        return cityOptional.orElse(null);
    }

    public City createCity(City city) {
        City existingCity = cityRepository.findByCityName(city.getCityName());
        if (existingCity != null) {
            throw new DataAlreadyAddedException();
        }

        return cityRepository.save(city);
    }

    public ResponseEntity<Object> deleteCity(String cityId) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        if (cityOptional.isEmpty()) {
            throw new DataNotFoundException();
        }

        cityRepository.deleteById(cityId);

        return new ResponseEntity<>("City was deleted successfully!", HttpStatus.OK);
    }

    public City updateCity(String cityId, City updatedCity) {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        if (cityOptional.isEmpty()) {
            throw new DataNotFoundException();
        }

        City existingCity = cityOptional.get();
        existingCity.setCityName(updatedCity.getCityName());

        return cityRepository.save(existingCity);
    }

    public List<City> findCitiesByName(String cityName) {
        return cityRepository.findByCityNameContainingIgnoreCase(cityName);
    }
}