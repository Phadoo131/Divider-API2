package com.b9ine.divider.controller;

import com.b9ine.divider.model.Client;
import com.b9ine.divider.model.Restaurant;
import com.b9ine.divider.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/divider/")
public class RestaurantController {

    @Autowired
    RestaurantService rsService;

    @GetMapping("/restaurants/")
    List<Restaurant> selectOne(@RequestParam String city) {
        List<Restaurant> answer = null;

        if (city.isEmpty()) {
            return rsService.findAll();
        } else {
            answer = rsService.findSpecificOne(city);
            return answer;
        }
    }

    @GetMapping("/restaurants/{id}")
    Optional<Restaurant> findOne(@PathVariable("id") Integer id){
        return rsService.findOne(id);
    }

    @PostMapping("/restaurants/")
    Restaurant addOne(@RequestBody Restaurant res){
        return rsService.createAccount(res);
    }

    @PutMapping("/restaurants/{id}")
    Restaurant updateOne(@RequestBody Restaurant res, @PathVariable("id") Integer id) {
        return rsService.updateClient(res, id);
    }

    @DeleteMapping("/restaurants/{id}")
    ResponseEntity<Object> deleteOne(@PathVariable("id") Integer id) {
        return rsService.deleteAccount(id);
    }

}
