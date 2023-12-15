package com.b9ine.divider.repository;

import com.b9ine.divider.model.Booker;
import com.b9ine.divider.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByEmail(String email);

    List<Client> findByCity(String city);
}
