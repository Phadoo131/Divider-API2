package com.b9ine.divider.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.b9ine.divider.dto.BookerDTO;
import com.b9ine.divider.util.MapperUtil;
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
	List<BookerDTO> findAll(@RequestParam String city) {
		List<BookerDTO> answer;

		if (city.isEmpty()) {
			// http://localhost:8080/bookers/?city=
			return bkService.findAll().stream()
					.map(MapperUtil::convertToDTO)
					.collect(Collectors.toList());
		} else {
			answer = bkService.findSpecificOne(city).stream()
					.map(MapperUtil::convertToDTO)
					.collect(Collectors.toList());
			return answer;
		}
	}
	@GetMapping("/bookers/{id}")
	Optional<BookerDTO> findOne(@PathVariable("id") Integer id) {
		return bkService.findOne(id).map(MapperUtil::convertToDTO);
	}

	@PostMapping("/bookers/")
	BookerDTO addOne(@RequestBody BookerDTO bookerDTO) {
		Booker booker = MapperUtil.convertToEntity(bookerDTO);
		Booker savedBooker = bkService.createAccount(booker);
		return MapperUtil.convertToDTO(savedBooker);
	}

	@PutMapping("/bookers/{id}")
	BookerDTO updateOne(@RequestBody BookerDTO bookerDTO, @PathVariable("id") Integer id) {
		Booker booker = MapperUtil.convertToEntity(bookerDTO);
		Booker updatedBooker = bkService.updateBooker(booker, id);
		return MapperUtil.convertToDTO(updatedBooker);
	}

	@DeleteMapping("/bookers/{id}")
	ResponseEntity<Object> deleteOne(@PathVariable("id") Integer id) {
		return bkService.deleteAccount(id);
	}
}
