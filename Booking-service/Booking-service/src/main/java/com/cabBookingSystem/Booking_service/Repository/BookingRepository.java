package com.cabBookingSystem.Booking_service.Repository;


import com.cabBookingSystem.Booking_service.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
        List<Booking> findByUserId(Long userId);
    }


