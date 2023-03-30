package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.SysRoleMenu;
import com.example.hncs.mapper.SysRoleMenuMapper;
import com.example.hncs.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色和菜单关联Service业务层处理
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper,SysRoleMenu> implements ISysRoleMenuService {
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 查询角色和菜单关联
     *
     * @param roleId 角色和菜单关联主键
     * @return 角色和菜单关联
     */
    @Override
    public SysRoleMenu selectSysRoleMenuByRoleId(Long roleId) {
        return sysRoleMenuMapper.selectSysRoleMenuByRoleId(roleId);
    }

    /**
     * 查询角色和菜单关联列表
     *
     * @param sysRoleMenu 角色和菜单关联
     * @return 角色和菜单关联
     */
    @Override
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.selectSysRoleMenuList(sysRoleMenu);
    }

    /**
     * 新增角色和菜单关联
     *
     * @param sysRoleMenu 角色和菜单关联
     * @return 结果
     */
    @Override
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.insertSysRoleMenu(sysRoleMenu);
    }

    /**
     * 修改角色和菜单关联
     *
     * @param sysRoleMenu 角色和菜单关联
     * @return 结果
     */
    @Override
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.updateSysRoleMenu(sysRoleMenu);
    }

    /**
     * 批量删除角色和菜单关联
     *
     * @param roleIds 需要删除的角色和菜单关联主键
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuByRoleIds(Long[] roleIds) {
        return sysRoleMenuMapper.deleteSysRoleMenuByRoleIds(roleIds);
    }

    /**
     * 删除角色和菜单关联信息
     *
     * @param roleId 角色和菜单关联主键
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuByRoleId(Long roleId) {
        return sysRoleMenuMapper.deleteSysRoleMenuByRoleId(roleId);
    }
}
