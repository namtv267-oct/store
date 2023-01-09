package com.store.controllers;

import com.store.dto.UserDto;
import com.store.repositories.UserRepository;
import com.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }
    @PostMapping("/register")
    public ModelAndView register(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return new ModelAndView("home","recommend","User is existed!");
        }
        userService.save(userDto);
        return new ModelAndView("home","recommend","User signed success!");
    }
}
