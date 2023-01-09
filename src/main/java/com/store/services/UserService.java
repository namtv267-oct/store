package com.store.services;

import com.store.dto.UserDto;
import com.store.entities.DetailUserE;
import com.store.entities.RoleE;
import com.store.entities.UserE;
import com.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserE save(UserDto userDto) {
        UserE user = new UserE();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAuthorities(Collections.singleton(new RoleE("USER")));
        DetailUserE detailUserE = new DetailUserE();
        detailUserE.setAddress(userDto.getAddress());
        detailUserE.setFirstName(userDto.getFirstName());
        detailUserE.setLastName(userDto.getLastName());
        detailUserE.setAddress(userDto.getAddress());
        detailUserE.setPhone(userDto.getPhone());
        user.setDetailUserE(detailUserE);
        return userRepository.save(user);
    }
}
