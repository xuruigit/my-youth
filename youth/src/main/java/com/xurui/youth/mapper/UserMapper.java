package com.xurui.youth.mapper;

import com.xurui.youth.condition.UserCondition;
import com.xurui.youth.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xurui
 */
@Mapper
@Validated
public interface UserMapper {

    /**
     * 新增
     * @param record user
     * @return 主键
     */
    long insert(User record);

    /**
     * 主键查询
     * @param id 主键
     * @return User
     */
    User selectByPrimaryKey(Long id);

    /**
     * 条件查询
     * @param userCondition 条件
     * @return 用户列表
     */
    List<User> list(@Valid UserCondition userCondition);

    /**
     * 主键删除
     * @param id 主键
     * @return num
     */
    int deleteByPrimaryKey(Long id);

}