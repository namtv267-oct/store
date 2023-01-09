package com.store.services;

import com.store.dto.UserDto;
import com.store.entities.UserE;

public interface IUserService {
    UserE save(UserDto userDto);

}
