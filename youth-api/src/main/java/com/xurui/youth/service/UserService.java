package com.xurui.youth.service;

import com.xurui.youth.dto.UserDTO;

/**
 * 用户服务
 * Created by xurui on 2018/4/9.
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return UserDTO
     */
    UserDTO get(Long id);
}
