package com.b9ine.divider.service;

import com.b9ine.divider.exception.DataAlreadyAddedException;
import com.b9ine.divider.exception.DataNotFoundException;
import com.b9ine.divider.model.Client;
import com.b9ine.divider.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repo;

    public List<Client> findAll(){
        return repo.findAll();
    }

    public Optional<Client> findOne(Integer id) {
        Optional<Client> checker = repo.findById(id);

        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        }

        return checker;
    }

    public Client createAccount(Client client) {
        Client checker = repo.findByEmail(client.getEmail());

        if (checker != null) {
            throw new DataAlreadyAddedException();
        }

        return repo.save(client);
    }

    public ResponseEntity<Object> deleteAccount(Integer id) {
        Optional<Client> checker = repo.findById(id);

        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        }

        repo.deleteById(id);

        return new ResponseEntity<>("Account was deleted successfully!", HttpStatus.OK);
    }

    public Client updateClient(Client client, Integer id) {
        Optional<Client> checker = repo.findById(id);
        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        } else {
            return repo.save(client);
        }

    }

    public List<Client> findSpecificOne(String city) {
        return repo.findByCity(city);
    }
}
