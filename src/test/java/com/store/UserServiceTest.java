package com.store;

import com.store.dto.UserDto;
import com.store.entities.RoleE;
import com.store.repositories.RoleRepository;
import com.store.repositories.UserRepository;
import com.store.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired// Lấy mock ra từ một bean "giả" mà không cần để ý tới bean thật.( Tạo 1 bean giả)
    public UserRepository userRepository;
    @Autowired
    public UserService userService;


    @Test
    public void UserService_test(){
        UserDto userDto = new UserDto("John","Sonder","sonder998@email.com","sonder","NewYork City","+99999999");
        userService.save(userDto);
    }
    @Test
    public void isExistUname_test(){
        userRepository.deleteById(1L);
    }
}


