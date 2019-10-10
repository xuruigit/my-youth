package com.xurui.youth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xurui.youth.condition.UserCondition;
import com.xurui.youth.dto.UserDTO;
import com.xurui.youth.entity.User;
import com.xurui.youth.mapper.UserMapper;
import com.xurui.youth.service.UserService;
import com.xurui.youth.util.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author XuRui
 * @date 2018/4/9
 */
@Service(interfaceClass = UserService.class)
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
     * 查询用户列表
     *
     * @param condition 查询条件
     * @return 用户列表
     */
    @Override
    public List<UserDTO> list(UserCondition condition) {
        List<User> list = userMapper.list(condition);
        return ConvertUtil.converts(list, UserDTO.class);
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return userDTO
     */
    @Override
    public UserDTO add(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        long id = userMapper.insert(user);
        userDTO.setId(id);
        return userDTO;
    }

}
