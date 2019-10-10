package com.xurui.youth.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户DTO
 * Created by XuRui on 2018/4/9.
 */
@Data
public class UserDTO implements Serializable{

    private static final long serialVersionUID = 6469936779243069071L;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 账户
     **/
    @NotNull
    private String account;

    /**
     * 名称
     **/
    @NotNull
    private String name;

    /**
     * 密码
     **/
    @Pattern(regexp = "/((\\%3D)|(=))[^\\n]*((\\%27)|(\\’)|(\\-\\-)|(\\%3B)|(:))/i")
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
