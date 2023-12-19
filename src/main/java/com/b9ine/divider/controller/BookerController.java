package com.b9ine.divider.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.b9ine.divider.model.Booker;
import com.b9ine.divider.service.BookerService;

@RestController
@RequestMapping("/divider")
public class BookerController {

	@Autowired
	BookerService bkService;

	@GetMapping("/bookers/")
	List<Booker> findAll(@RequestParam String city){
		//return bkService.findAll();

		List<Booker> answer = null;

		if (city.isEmpty()) {
			//http://localhost:8080/bookers/?city=
			return bkService.findAll();
		} else {
			answer = bkService.findSpecificOne(city);
			return answer;
		}
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
