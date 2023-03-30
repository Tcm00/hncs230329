package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 角色信息对象 sys_role
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Data
public class SysRole {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    //@Excel(name = "角色名称")
    private String roleName;

    /**
     * 角色权限字符串
     */
    //@Excel(name = "角色权限字符串")
    @TableField(value = "role_key")
    private String roleKey;

    /**
     * 显示顺序
     */
    //@Excel(name = "显示顺序")
    @TableField(value = "role_sort")
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    //@Excel(name = "数据范围", readConverterExp = "1=：全部数据权限,2=：自定数据权限,3=：本部门数据权限,4=：本部门及以下数据权限")
    @TableField(value = "data_scope")
    private String dataScope;

    /**
     * 菜单树选择项是否关联显示
     */
    //@Excel(name = "菜单树选择项是否关联显示")
    @TableField(value = "menu_check_strictly")
    private Integer menuCheckStrictly;

    /**
     * 部门树选择项是否关联显示
     */
    //@Excel(name = "部门树选择项是否关联显示")
    @TableField(value = "dept_check_strictly")
    private Integer deptCheckStrictly;

    /**
     * 角色状态（0正常 1停用）
     */
    //@Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
    @TableField(value = "status")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableField(value = "del_flag")
    private String delFlag;

}
