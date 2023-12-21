package com.b9ine.divider.controller;

import com.b9ine.divider.dto.CityDTO;
import com.b9ine.divider.model.City;
import com.b9ine.divider.service.CityService;
import com.b9ine.divider.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divider")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities().stream()
                .map(MapperUtil::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/cities/{cityId}")
    public CityDTO getCityById(@PathVariable String cityId) {
        City city = cityService.getCityById(cityId);
        return MapperUtil.convertToDTO(city);
    }

    @PostMapping("/cities")
    public CityDTO createCity(@RequestBody CityDTO cityDTO) {
        City city = MapperUtil.convertToEntity(cityDTO);
        return MapperUtil.convertToDTO(cityService.createCity(city));
    }

    @PutMapping("/cities/{cityId}")
    public CityDTO updateCity(@PathVariable String cityId, @RequestBody CityDTO updatedCityDTO) {
        City updatedCity = MapperUtil.convertToEntity(updatedCityDTO);
        return MapperUtil.convertToDTO(cityService.updateCity(cityId, updatedCity));
    }

    @DeleteMapping("/cities/{cityId}")
    public void deleteCity(@PathVariable String cityId) {
        cityService.deleteCity(cityId);
    }
}
