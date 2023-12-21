package com.b9ine.divider.controller;

import com.b9ine.divider.dto.BookingDTO;
import com.b9ine.divider.model.Booking;
import com.b9ine.divider.service.BookingService;
import com.b9ine.divider.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divider")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/bookings")
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings().stream()
                .map(MapperUtil::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id)
                .map(booking -> ResponseEntity.ok(MapperUtil.convertToDTO(booking)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/bookings/")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = MapperUtil.convertToEntity(bookingDTO);
        return ResponseEntity.ok(MapperUtil.convertToDTO(bookingService.createBooking(booking)));
    }

    @PutMapping("/bookings/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Integer id,
                                                    @RequestBody BookingDTO updatedBookingDTO) {
        Booking updatedBooking = MapperUtil.convertToEntity(updatedBookingDTO);
        Booking result = bookingService.updateBooking(id, updatedBooking);
        if (result != null) {
            return ResponseEntity.ok(MapperUtil.convertToDTO(result));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/bookings/{id}/finish")
    public ResponseEntity<BookingDTO> updateBookingStatus(@PathVariable Integer id,
                                                          @RequestParam String bookingStatus) {
        Booking result = bookingService.updateBookingStatus(id, bookingStatus);
        if (result != null) {
            return ResponseEntity.ok(MapperUtil.convertToDTO(result));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Object> deleteBooking(@PathVariable Integer id) {
        return bookingService.deleteBooking(id);
    }
}
