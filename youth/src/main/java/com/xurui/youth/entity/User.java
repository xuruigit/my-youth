package com.xurui.youth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author XuRui
 * @date 2018/4/13
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    **/
    private Long id;

    /**
    * 账户
    **/
    private String account;

    /**
    * 名称
    **/
    private String name;

    /**
    * 密码
    **/
    private String password;

    /**
    * 用户类型：1普通，0管理员
    **/
    private Byte type;

    /**
    * 用户状态：1正常，0停用
    **/
    private Byte status;

    /**
    * 是否已被删除： 1是，0否
    **/
    private Byte isDeleted;

    /**
    * 创建时间
    **/
    private Date gmtCreated;

    /**
    * 修改时间
    **/
    private Date gmtModified;

}