package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.SysMenu;
import com.example.hncs.mapper.SysMenuMapper;
import com.example.hncs.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单权限Service业务层处理
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper,SysMenu> implements ISysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询菜单权限
     *
     * @param menuId 菜单权限主键
     * @return 菜单权限
     */
    @Override
    public SysMenu selectSysMenuByMenuId(Long menuId) {
        return sysMenuMapper.selectSysMenuByMenuId(menuId);
    }

    /**
     * 查询菜单权限列表
     *
     * @param sysMenu 菜单权限
     * @return 菜单权限
     */
    @Override
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu) {
        return sysMenuMapper.selectSysMenuList(sysMenu);
    }

    /**
     * 新增菜单权限
     *
     * @param sysMenu 菜单权限
     * @return 结果
     */
    @Override
    public int insertSysMenu(SysMenu sysMenu) {
//        sysMenu.setCreateTime(DateUtils.getNowDate());
        return sysMenuMapper.insertSysMenu(sysMenu);
    }

    /**
     * 修改菜单权限
     *
     * @param sysMenu 菜单权限
     * @return 结果
     */
    @Override
    public int updateSysMenu(SysMenu sysMenu) {
//        sysMenu.setUpdateTime(DateUtils.getNowDate());
        return sysMenuMapper.updateSysMenu(sysMenu);
    }

    /**
     * 批量删除菜单权限
     *
     * @param menuIds 需要删除的菜单权限主键
     * @return 结果
     */
    @Override
    public int deleteSysMenuByMenuIds(Long[] menuIds) {
        return sysMenuMapper.deleteSysMenuByMenuIds(menuIds);
    }

    /**
     * 删除菜单权限信息
     *
     * @param menuId 菜单权限主键
     * @return 结果
     */
    @Override
    public int deleteSysMenuByMenuId(Long menuId) {
        return sysMenuMapper.deleteSysMenuByMenuId(menuId);
    }
}
