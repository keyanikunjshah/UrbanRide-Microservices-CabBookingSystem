package com.cabBookingSystem.user_service.Repository;

import com.cabBookingSystem.user_service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByemail(String email);

}
//optional handers null pointer exception if no user is found then
//If findUserByEmail() returns null, calling .getPassword() will throw a NullPointerException.
//: Optional<User> ensures that we check if the value exists before using it.