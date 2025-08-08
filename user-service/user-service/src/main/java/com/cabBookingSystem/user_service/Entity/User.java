package com.cabBookingSystem.user_service.Entity;


import jakarta.persistence.*;

@Entity

@Table(name ="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private  String name;


    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


//    enums are special datatypes in java that enable u
//    to define and restrict a variable to have only of a
//    predefined set of constant values (fixed values that dont change during
//    program execution)
//        before enums private static int final
    //tyep safety


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    private  String phoneNumeber;


    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public User(long id, String name, String email, String password, UserRole role, String phoneNumeber, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumeber = phoneNumeber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User(){}




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhoneNumeber() {
        return phoneNumeber;
    }

    public void setPhoneNumeber(String phoneNumeber) {
        this.phoneNumeber = phoneNumeber;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }








}
