package com.cabBookingSystem.cab_service.Repository;



import com.cabBookingSystem.cab_service.Entity.Cab;
import com.cabBookingSystem.cab_service.Entity.CabStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CabRepository extends JpaRepository<Cab,Long> {
    List<Cab> findByStatus(CabStatus status);
    Optional<Cab> findByDriverId(Long driverId);

}
