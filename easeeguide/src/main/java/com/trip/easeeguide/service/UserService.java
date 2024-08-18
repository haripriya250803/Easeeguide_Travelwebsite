package com.trip.easeeguide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.easeeguide.entity.Users;
import com.trip.easeeguide.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
// package com.trip.easeeguide.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.trip.easeeguide.entity.User;
// import com.trip.easeeguide.repository.UserRepository;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Transactional
//     public User saveUser(User user) {
//         try {
//             return userRepository.save(user);
//         } catch (Exception e) {
//             throw new RuntimeException("Error saving user: " + e.getMessage());
//         }
//     }

//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }

//     public Optional<User> getUserById(Long id) {
//         return userRepository.findById(id);
//     }

//     public void deleteUser(Long id) {
//         userRepository.deleteById(id);
//     }
// }