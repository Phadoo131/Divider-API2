package com.b9ine.divider.service;

import java.util.List;
import java.util.Optional;

import com.b9ine.divider.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.b9ine.divider.exception.CustomerAlreadyAddedException;
import com.b9ine.divider.exception.CustomerNotFoundException;
import com.b9ine.divider.model.Booker;
import com.b9ine.divider.repository.BookerRepository;

@Service
public class BookerService {

	@Autowired
	BookerRepository repo;
	
	public List<Booker> findAll(){
		return repo.findAll();
	}
	
	public Optional<Booker> findOne(Integer id) {
		Optional<Booker> checker = repo.findById(id);
		
		if (checker == null) {
			throw new CustomerNotFoundException();
		}
		
		return checker;
	}
	
	public Booker createAccount(Booker booker) {
		Booker checker = repo.findByEmail(booker.getEmail());
		
		if (checker != null) {
			throw new CustomerAlreadyAddedException(checker);
		}
		
		return repo.save(booker);
	}
	
	public ResponseEntity<Object> deleteAccount(Integer id) {
		Optional<Booker> checker = repo.findById(id);
		
		if (checker != null) {
			throw new CustomerAlreadyAddedException(null);
		}
		
		repo.deleteById(id);
		
		return new ResponseEntity<>("Account was deleted successfully!", HttpStatus.OK);
	}
	
	public Booker updateBooker(Booker booker, Integer id) {
		Optional<Booker> checker = repo.findById(id);
		if (checker.isEmpty()) {
			throw new CustomerNotFoundException();
		} else {
			Booker newBooker = checker.get();
			newBooker = booker;

			return repo.save(booker);
		}
		
	}

	public List<Booker> findSpecificOne(String city){
		return repo.findByCity(city);
	}



}
