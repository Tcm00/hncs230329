package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 用户和角色关联对象 sys_user_role
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Data
public class SysUserRole {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

}
