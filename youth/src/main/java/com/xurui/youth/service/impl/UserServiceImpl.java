package com.xurui.youth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xurui.youth.dto.UserDTO;
import com.xurui.youth.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 用户服务实现
 * Created by XuRui on 2018/4/9.
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO get(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("Jeff");
        return userDTO;
    }
}
