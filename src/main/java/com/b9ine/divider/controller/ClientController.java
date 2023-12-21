package com.b9ine.divider.controller;

import com.b9ine.divider.dto.ClientDTO;
import com.b9ine.divider.model.Booker;
import com.b9ine.divider.model.Client;
import com.b9ine.divider.service.ClientService;
import com.b9ine.divider.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divider")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/clients/")
    List<ClientDTO> selectOne(@RequestParam String city) {
        List<ClientDTO> answer;

        if (city.isEmpty()) {
            return service.findAll().stream()
                    .map(MapperUtil::convertToDTO)
                    .collect(Collectors.toList());
        } else {
            answer = service.findSpecificOne(city).stream()
                    .map(MapperUtil::convertToDTO)
                    .collect(Collectors.toList());
            return answer;
        }
    }

    @GetMapping("/clients/{id}")
    Optional<ClientDTO> findOne(@PathVariable("id") Integer id) {
        return service.findOne(id).map(MapperUtil::convertToDTO);
    }

    @PostMapping("/clients/")
    ClientDTO addOne(@RequestBody ClientDTO clientDTO) {
        Client client = MapperUtil.convertToEntity(clientDTO);
        Client savedClient = service.createAccount(client);
        return MapperUtil.convertToDTO(savedClient);
    }

    @PutMapping("/clients/{id}")
    ClientDTO updateOne(@RequestBody ClientDTO clientDTO, @PathVariable("id") Integer id) {
        Client client = MapperUtil.convertToEntity(clientDTO);
        Client updatedClient = service.updateClient(client, id);
        return MapperUtil.convertToDTO(updatedClient);
    }

    @DeleteMapping("/clients/{id}")
    ResponseEntity<Object> deleteOne(@PathVariable("id") Integer id) {
        return service.deleteAccount(id);
    }
}
