package com.xurui.youth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xurui.youth.dto.UserDTO;
import com.xurui.youth.entity.User;
import com.xurui.youth.mapper.UserMapper;
import com.xurui.youth.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现
 * Created by XuRui on 2018/4/9.
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return UserDTO
     */
    @Override
    public UserDTO get(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(null == user){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return userDTO
     */
    @Override
    @Transactional
    public UserDTO add(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        long id = userMapper.insert(user);
        userDTO.setId(id);
//        throw new RuntimeException();
//        userMapper.insert(null);
        return userDTO;
    }


}
