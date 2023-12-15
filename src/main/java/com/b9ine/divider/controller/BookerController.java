package com.b9ine.divider.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b9ine.divider.model.Booker;
import com.b9ine.divider.service.BookerService;

@RestController
@RequestMapping("/divider")
public class BookerController {

	@Autowired
	BookerService bkService;
	
//	@Autowired
//	ClientService clientService;
//	
//	@Autowired
//	BookingService bookingService;
//	
//	@Autowired
//	RestaurantService rsService;
	
	@GetMapping("/bookers")
	List<Booker> findAll(){
		return bkService.findAll();
	}
	
	@GetMapping("/bookers/{id}")
	Optional<Booker> findOne(@PathVariable("id") Integer id){
		return bkService.findOne(id);
	}
	
	@PostMapping("/bookers/")
	Booker addOne(@RequestBody Booker booker){
		return bkService.createAccount(booker);
	}
	
	@PutMapping("/bookers/{id}")
	Booker updateOne(@RequestBody Booker booker, @PathVariable("id") Integer id) {
		return bkService.updateBooker(booker, id);
	}
	
	@DeleteMapping("/bookers/{id}")
	ResponseEntity<Object> deleteOne(@PathVariable("id") Integer id) {
		return bkService.deleteAccount(id);
	}
	
	
	
}
