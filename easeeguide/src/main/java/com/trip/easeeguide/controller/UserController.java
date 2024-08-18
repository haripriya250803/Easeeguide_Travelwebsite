package com.trip.easeeguide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.trip.easeeguide.entity.Users;
import com.trip.easeeguide.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/project")
    public ModelAndView superv() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/get")
    public List<Users> getall()
    {
        return userRepository.findAll();
    }

    // @GetMapping("/gett")
    // public String getallhg()
    // {
    //     return "haiii";
    // }

@PostMapping("/path")
public Users postMethodName(@RequestBody Users user) {
    userRepository.save(user);
    return user;
}
    
}
