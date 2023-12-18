package com.b9ine.divider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.b9ine.divider.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
