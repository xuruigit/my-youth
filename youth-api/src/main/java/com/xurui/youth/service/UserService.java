package com.xurui.youth.service;

import com.xurui.youth.condition.UserCondition;
import com.xurui.youth.dto.UserDTO;

import java.util.List;

/**
 * 用户服务
 *
 * @author xurui
 * @date 2018/4/9
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     * 
     * @param id 用户id
     * @return UserDTO
     */
    UserDTO get(Long id);

    /**
     * 查询用户列表
     * @param condition 查询条件
     * @return 用户列表
     */
    List<UserDTO> list(UserCondition condition);

    /**
     * 新增用户
     * 
     * @param userDTO 用户信息
     * @return userDTO
     */
    UserDTO add(UserDTO userDTO);

}
