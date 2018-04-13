package com.xurui.youth.test;

import com.xurui.youth.dto.UserDTO;
import com.xurui.youth.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户服务单元测试
 * Created by XuRui on 2018/4/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGet() {
        UserDTO userDTO = userService.get(1L);
        System.err.println(userDTO.getName());
    }
}
