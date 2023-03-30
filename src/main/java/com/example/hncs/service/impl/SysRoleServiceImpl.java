package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.SysRole;
import com.example.hncs.mapper.SysRoleMapper;
import com.example.hncs.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息Service业务层处理
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole>  implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询角色信息
     *
     * @param roleId 角色信息主键
     * @return 角色信息
     */
    @Override
    public SysRole selectSysRoleByRoleId(Long roleId) {
        return sysRoleMapper.selectSysRoleByRoleId(roleId);
    }

    /**
     * 查询角色信息列表
     *
     * @param sysRole 角色信息
     * @return 角色信息
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole) {
        return sysRoleMapper.selectSysRoleList(sysRole);
    }

    /**
     * 新增角色信息
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    @Override
    public int insertSysRole(SysRole sysRole) {
//        sysRole.setCreateTime(DateUtils.getNowDate());
        return sysRoleMapper.insertSysRole(sysRole);
    }

    /**
     * 修改角色信息
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    @Override
    public int updateSysRole(SysRole sysRole) {
//        sysRole.setUpdateTime(DateUtils.getNowDate());
        return sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 批量删除角色信息
     *
     * @param roleIds 需要删除的角色信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRoleByRoleIds(Long[] roleIds) {
        return sysRoleMapper.deleteSysRoleByRoleIds(roleIds);
    }

    /**
     * 删除角色信息信息
     *
     * @param roleId 角色信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRoleByRoleId(Long roleId) {
        return sysRoleMapper.deleteSysRoleByRoleId(roleId);
    }
}
