package com.example.hncs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hncs.domain.SysMenu;

import java.util.List;

/**
 * 菜单权限Service接口
 *
 * @author tangcanming
 * @date 2023-03-29
 */
public interface ISysMenuService extends IService<SysMenu> {
    /**
     * 查询菜单权限
     *
     * @param menuId 菜单权限主键
     * @return 菜单权限
     */
    public SysMenu selectSysMenuByMenuId(Long menuId);

    /**
     * 查询菜单权限列表
     *
     * @param sysMenu 菜单权限
     * @return 菜单权限集合
     */
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    /**
     * 新增菜单权限
     *
     * @param sysMenu 菜单权限
     * @return 结果
     */
    public int insertSysMenu(SysMenu sysMenu);

    /**
     * 修改菜单权限
     *
     * @param sysMenu 菜单权限
     * @return 结果
     */
    public int updateSysMenu(SysMenu sysMenu);

    /**
     * 批量删除菜单权限
     *
     * @param menuIds 需要删除的菜单权限主键集合
     * @return 结果
     */
    public int deleteSysMenuByMenuIds(Long[] menuIds);

    /**
     * 删除菜单权限信息
     *
     * @param menuId 菜单权限主键
     * @return 结果
     */
    public int deleteSysMenuByMenuId(Long menuId);
}
