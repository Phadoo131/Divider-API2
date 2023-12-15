package com.b9ine.divider.controller;

import com.b9ine.divider.model.Booker;
import com.b9ine.divider.model.Client;
import com.b9ine.divider.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dividers")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/clients/")
    List<Client> selectOne(@RequestParam String city) {
        List<Client> answer = null;

        if (city.isEmpty()) {
            //http://localhost:8080/bookers/?city=
            return service.findAll();
        } else {
            answer = service.findSpecificOne(city);
            return answer;
        }
    }

    @GetMapping("/clients/{id}")
    Optional<Client> findOne(@PathVariable("id") Integer id){
        return service.findOne(id);
    }

    @PostMapping("/clients/")
    Client addOne(@RequestBody Client client){
        return service.createAccount(client);
    }

    @PutMapping("/clients/{id}")
    Client updateOne(@RequestBody Client client, @PathVariable("id") Integer id) {
        return service.updateClient(client, id);
    }

    @DeleteMapping("/clients/{id}")
    ResponseEntity<Object> deleteOne(@PathVariable("id") Integer id) {
        return service.deleteAccount(id);
    }



}
