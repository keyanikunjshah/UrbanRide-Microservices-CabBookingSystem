package com.cabBookingSystem.cab_service.Service;

import com.cabBookingSystem.cab_service.DTO.DriverLocationDTO;
import com.cabBookingSystem.cab_service.Entity.Cab;
import com.cabBookingSystem.cab_service.Entity.CabStatus;
import com.cabBookingSystem.cab_service.Repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CabService {
    @Autowired
    private CabRepository cabRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Cab registerCab(Cab cab) {
        return cabRepository.save(cab);
    }

    public Optional<Cab> getCabByDriverId(Long driverId) {
        return cabRepository.findByDriverId(driverId);
    }



    public Optional<Cab> updateCabStatus(Long id, CabStatus status) {
        Optional<Cab> cab = cabRepository.findById(id);
        cab.ifPresent(c -> {
            c.setStatus(status);
            cabRepository.save(c);
        });
        return cab;
    }

    public List<Cab> getAvailableCabs(double userLatitude, double userLongitude) {
        List<Cab> allAvailableCabs = cabRepository.findByStatus(CabStatus.AVAILABLE);

        List<Cab> nearbyCabs = new ArrayList<>();

        for (Cab cab : allAvailableCabs) {
            Long driverId = cab.getDriverId();

            DriverLocationDTO driverlocation = restTemplate.getForObject("http://user-service/users/driver/" + driverId + "/location", DriverLocationDTO.class);

            if (driverlocation != null) {
                double distance = calculateDistance(
                        userLatitude, userLongitude,
                        driverlocation.getLatitude(), driverlocation.getLongitude());

                if (distance <= 5.0) { // within 5 km
                    nearbyCabs.add(cab);
                }


            }
        }

        return nearbyCabs;

    }
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine formula
        final int R = 6371; // Radius of Earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

}




