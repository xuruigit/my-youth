package com.xurui.youth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xurui.youth.dto.UserDTO;
import com.xurui.youth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户Controller
 * Created by XuRui on 2018/4/9.
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public UserDTO list(){
        return userService.get(1L);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public UserDTO add(@RequestBody @Valid UserDTO userDTO){
        return userService.add(userDTO);
    }
}
