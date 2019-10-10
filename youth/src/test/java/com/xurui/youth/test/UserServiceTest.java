package com.xurui.youth.test;

import com.google.common.collect.Lists;
import com.xurui.youth.condition.UserCondition;
import com.xurui.youth.dto.UserDTO;
import com.xurui.youth.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

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
        Assert.assertNotNull(userDTO);
    }

    /**
     * 查询时没有指定必须的参数，则禁止查询
     */
    @Test
    public void testConditionNotAuthorized() {
        UserCondition condition = new UserCondition();
        condition.setStatus(1);
        try {
            userService.list(condition);
        }catch (ConstraintViolationException e){
            Set<ConstraintViolation<?>> v = e.getConstraintViolations();
            v.forEach(vv -> System.err.println(vv.getMessage()));
        }
    }

    /**
     * 查询时指定了必须的参数，则允许查询
     */
    @Test
    public void testConditionAuthorized() {
        UserCondition condition = new UserCondition();
        List<UserDTO> userDTOList = Lists.newArrayList();
        // 指定类型+状态查询
        condition.setType(1);
        condition.setStatus(1);
        try {
            userDTOList = userService.list(condition);
        }catch (ConstraintViolationException e){
            System.err.println(e.getMessage());
        }
        System.err.println("userName：" + userDTOList.get(0).getName());
    }

    @Test
    public void testTransaction(){
        UserDTO userDTO = userService.get(1L);
        userDTO.setAccount("123456789012345678901");
        userService.add(userDTO);
    }
}
