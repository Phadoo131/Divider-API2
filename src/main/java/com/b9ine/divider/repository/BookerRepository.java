package com.b9ine.divider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b9ine.divider.model.Booker;

public interface BookerRepository extends JpaRepository<Booker, Integer>{
	public Booker findByEmail(String email);
}
