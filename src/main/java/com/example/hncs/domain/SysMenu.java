package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 菜单权限对象 sys_menu
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Data
public class SysMenu {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    private Long menuId;

    /**
     * 菜单名称
     */
    ////@Excel(name = "菜单名称")
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 父菜单ID
     */
    //@Excel(name = "父菜单ID")
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 显示顺序
     */
    //@Excel(name = "显示顺序")
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 路由地址
     */
    //@Excel(name = "路由地址")
    private String path;

    /**
     * 组件路径
     */
    //@Excel(name = "组件路径")
    private String component;

    /**
     * 路由参数
     */
    //@Excel(name = "路由参数")
    @TableField(value = "query")
    private String query;

    /**
     * 是否为外链（0是 1否）
     */
    //@Excel(name = "是否为外链", readConverterExp = "0=是,1=否")
    @TableField(value = "is_frame")
    private Integer isFrame;

    /**
     * 是否缓存（0缓存 1不缓存）
     */
    //@Excel(name = "是否缓存", readConverterExp = "0=缓存,1=不缓存")
    @TableField(value = "is_cache")
    private Integer isCache;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    //@Excel(name = "菜单类型", readConverterExp = "M=目录,C=菜单,F=按钮")
    @TableField(value = "menu_type")
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    //@Excel(name = "菜单状态", readConverterExp = "0=显示,1=隐藏")
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    //@Excel(name = "菜单状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 权限标识
     */
    //@Excel(name = "权限标识")
    private String perms;

    /**
     * 菜单图标
     */
    //@Excel(name = "菜单图标")
    private String icon;

}
