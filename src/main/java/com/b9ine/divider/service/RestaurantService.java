package com.b9ine.divider.service;

import com.b9ine.divider.exception.DataAlreadyAddedException;
import com.b9ine.divider.exception.DataNotFoundException;
import com.b9ine.divider.model.Restaurant;
import com.b9ine.divider.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    RestaurantRepository repo;

    public List<Restaurant> findAll(){
        return repo.findAll();
    }

    public Optional<Restaurant> findOne(Integer id) {
        Optional<Restaurant> checker = repo.findById(id);

        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        }

        return checker;
    }

    public Restaurant createAccount(Restaurant res) {
        Restaurant checker = repo.findByRsName(res.getRsName());

        if (checker != null) {
            throw new DataAlreadyAddedException();
        }

        return repo.save(res);
    }

    public ResponseEntity<Object> deleteAccount(Integer id) {
        Optional<Restaurant> checker = repo.findById(id);

        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        }

        repo.deleteById(id);

        return new ResponseEntity<>("Restaurant was deleted successfully!", HttpStatus.OK);
    }

    public Restaurant updateClient(Restaurant res, Integer id) {
        Optional<Restaurant> checker = repo.findById(id);
        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        } else {
            Restaurant newRes = checker.get();
            newRes = res;

            return repo.save(newRes);
        }

    }

    public List<Restaurant> findSpecificOne(String city) {
        return repo.findByCity(city);
    }


}
