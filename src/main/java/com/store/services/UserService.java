package com.store.services;

import com.store.dto.UserDto;
import com.store.entities.Role;
import com.store.entities.User;
import com.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(), BCrypt.hashpw(userDto.getPassword(),"12"), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
