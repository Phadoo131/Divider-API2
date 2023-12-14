package com.b9ine.divider.repository;

import com.b9ine.divider.model.Booker;
import com.b9ine.divider.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByEmail(String email);
}
