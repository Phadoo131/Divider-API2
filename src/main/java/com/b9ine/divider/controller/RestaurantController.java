package com.b9ine.divider.controller;

import com.b9ine.divider.dto.RestaurantDTO;
import com.b9ine.divider.model.Client;
import com.b9ine.divider.model.Restaurant;
import com.b9ine.divider.service.RestaurantService;
import com.b9ine.divider.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divider")
public class RestaurantController {

    @Autowired
    RestaurantService rsService;

    @GetMapping("/restaurants/")
    List<RestaurantDTO> selectOne(@RequestParam String city) {
        List<RestaurantDTO> answer;

        if (city.isEmpty()) {
            return rsService.findAll().stream()
                    .map(MapperUtil::convertToDTO)
                    .collect(Collectors.toList());
        } else {
            answer = rsService.findSpecificOne(city).stream()
                    .map(MapperUtil::convertToDTO)
                    .collect(Collectors.toList());
            return answer;
        }
    }

    @GetMapping("/restaurants/{id}")
    ResponseEntity<RestaurantDTO> findOne(@PathVariable("id") Integer id) {
        return rsService.findOne(id)
                .map(restaurant -> ResponseEntity.ok(MapperUtil.convertToDTO(restaurant)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/restaurants/")
    RestaurantDTO addOne(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = MapperUtil.convertToEntity(restaurantDTO);
        return MapperUtil.convertToDTO(rsService.createAccount(restaurant));
    }

    @PutMapping("/restaurants/{id}")
    ResponseEntity<RestaurantDTO> updateOne(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Integer id) {
        Restaurant updatedRestaurant = MapperUtil.convertToEntity(restaurantDTO);
        Restaurant result = rsService.updateClient(updatedRestaurant, id);
        if (result != null) {
            return ResponseEntity.ok(MapperUtil.convertToDTO(result));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/restaurants/{id}")
    ResponseEntity<Object> deleteOne(@PathVariable("id") Integer id) {
        return rsService.deleteAccount(id);
    }
}
