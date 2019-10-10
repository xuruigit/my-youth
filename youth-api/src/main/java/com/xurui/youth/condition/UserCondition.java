package com.xurui.youth.condition;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.AssertTrue;
import java.io.Serializable;

/**
 * 用户查询条件
 *
 * @author XuRui
 * @date 2019/9/27
 */
@Data
@ToString
public class UserCondition implements Serializable {

    private static final long serialVersionUID = 6469936779243069072L;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 用户类型：1普通，0管理员
     **/
    private Integer type;

    /**
     * 用户状态：1正常，0停用
     **/
    private Integer status;

    /**
     * 查询条件兜底校验
     * <p>
     *  允许的场景：
     *      1. 指定id查询
     *      2. 指定用户类型和用户状态查询
     * </p>
     *
     * @return 查询条件是否合法
     */
    @AssertTrue(message = "缺少必要参数")
    private boolean isConditionAuthorized() {
        if (null != this.id) {
            return true;
        }
        return null != this.type && null != this.status;
    }
}
