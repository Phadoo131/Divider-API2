package com.b9ine.divider.service;

import com.b9ine.divider.exception.DataNotFoundException;
import com.b9ine.divider.model.Booking;
import com.b9ine.divider.model.Restaurant;
import com.b9ine.divider.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    BookingRepository repo;
    public List<Booking> getAllBookings() {
        return repo.findAll();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return repo.findById(id);
    }

    public Booking createBooking(Booking booking) {
        // Add any business logic or validation before saving
        return repo.save(booking);
    }

    public Booking updateBooking(Integer id, Booking updatedBooking) {
        return repo.findById(id)
                .map(existingBooking -> {
                    existingBooking.setClientId(updatedBooking.getClientId());
                    existingBooking.setBookerId(updatedBooking.getBookerId());
                    existingBooking.setRsId(updatedBooking.getRsId());
                    existingBooking.setTimeStamp(updatedBooking.getTimeStamp());
                    existingBooking.setBookingStatus(updatedBooking.getBookingStatus());
                    return repo.save(existingBooking);
                })
                .orElse(null);
    }

    public ResponseEntity<Object> deleteBooking(Integer id) {
        Optional<Booking> checker = repo.findById(id);

        if (checker.isEmpty()) {
            throw new DataNotFoundException();
        }

        repo.deleteById(id);

        return new ResponseEntity<>("Booking status was deleted successfully!", HttpStatus.OK);
    }

    public Booking updateBookingStatus(Integer id, String bookingStatus) {
        return repo.findById(id)
                .map(existingBooking -> {
                    existingBooking.setBookingStatus(bookingStatus);
                    return repo.save(existingBooking);
                })
                .orElseThrow(DataNotFoundException::new);
    }
}
