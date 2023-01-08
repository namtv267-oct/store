package com.store;

import com.store.repositories.UserRepository;
import com.store.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@TestConfiguration
public class UserServiceTest {
    @MockBean// Lấy mock ra từ một bean "giả" mà không cần để ý tới bean thật.( Tạo 1 bean giả)
    UserRepository userRepository;
    @MockBean public UserService userService;
    @Test
    public void UserServiceSaveE_Test(){
    }

}


