package com.cabBookingSystem.Booking_service.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long cabId;

    @Column(nullable = false)
    private double pickupLatitude;

    @Column(nullable = false)
    private double pickupLongitude;

    @Column(nullable = false)
    private double dropLatitude;

    @Column(nullable = false)
    private double dropLongitude;

    @Column(nullable = false)
    private LocalDateTime bookingTime;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private double fare;  // 👈 New field added

    public Booking() {
    }

    public Booking(Long userId, Long cabId, double pickupLatitude, double pickupLongitude,
                   double dropLatitude, double dropLongitude, LocalDateTime bookingTime,
                   boolean completed, double fare) {
        this.userId = userId;
        this.cabId = cabId;
        this.pickupLatitude = pickupLatitude;
        this.pickupLongitude = pickupLongitude;
        this.dropLatitude = dropLatitude;
        this.dropLongitude = dropLongitude;
        this.bookingTime = bookingTime;
        this.completed = completed;
        this.fare = fare;
    }

    // Getters and setters for all fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCabId() { return cabId; }
    public void setCabId(Long cabId) { this.cabId = cabId; }

    public double getPickupLatitude() { return pickupLatitude; }
    public void setPickupLatitude(double pickupLatitude) { this.pickupLatitude = pickupLatitude; }

    public double getPickupLongitude() { return pickupLongitude; }
    public void setPickupLongitude(double pickupLongitude) { this.pickupLongitude = pickupLongitude; }

    public double getDropLatitude() { return dropLatitude; }
    public void setDropLatitude(double dropLatitude) { this.dropLatitude = dropLatitude; }

    public double getDropLongitude() { return dropLongitude; }
    public void setDropLongitude(double dropLongitude) { this.dropLongitude = dropLongitude; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
}
