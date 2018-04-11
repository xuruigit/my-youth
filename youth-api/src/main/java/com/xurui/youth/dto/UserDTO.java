package com.xurui.youth.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户DTO
 * Created by XuRui on 2018/4/9.
 */
@Data
public class UserDTO implements Serializable{

    private static final long serialVersionUID = 6469936779243069071L;

    /** 主键 */
    private Long id;

    /** 名称 */
    private String name;
}
