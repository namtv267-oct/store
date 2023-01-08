package com.store.services;

import com.store.dto.UserDto;
import com.store.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User save(UserDto userDto);

}
