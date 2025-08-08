package com.cabBookingSystem.user_service.Service;

import com.cabBookingSystem.user_service.Entity.User;
import com.cabBookingSystem.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User registerUser(User user){
        return userRepository.save(user);

    }

    public Optional<User> loginUser(String email,String password){
        Optional<User> user=userRepository.findByemail(email);
                return user.filter(u-> u.getPassword().equals(password));
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
}
