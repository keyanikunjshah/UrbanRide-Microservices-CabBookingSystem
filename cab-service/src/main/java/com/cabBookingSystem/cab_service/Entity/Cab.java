package com.cabBookingSystem.cab_service.Entity;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "cabs")
public class Cab {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    String model;
    @Column(nullable = false, unique = true)
    String numberPlate;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CabStatus status;

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", status=" + status +
                ", driverId=" + driverId +
                '}';
    }

    private Long driverId;

    public Cab(Long id, String model, String numberPlate, CabStatus status, Long driverId) {
        this.id = id;
        this.model = model;
        this.numberPlate = numberPlate;
        this.status = status;
        this.driverId = driverId;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }


    public CabStatus getStatus() {
        return status;
    }

    public void setStatus(CabStatus status) {
        this.status = status;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }




    public Cab(){

    }
}

