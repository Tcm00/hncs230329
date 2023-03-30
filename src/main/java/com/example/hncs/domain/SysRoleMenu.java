package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 角色和菜单关联对象 sys_role_menu
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Data
public class SysRoleMenu {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Long menuId;

}
