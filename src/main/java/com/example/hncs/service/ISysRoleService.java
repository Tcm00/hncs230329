package com.example.hncs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hncs.domain.SysRole;

import java.util.List;

/**
 * 角色信息Service接口
 *
 * @author tangcanming
 * @date 2023-03-29
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 查询角色信息
     *
     * @param roleId 角色信息主键
     * @return 角色信息
     */
    public SysRole selectSysRoleByRoleId(Long roleId);

    /**
     * 查询角色信息列表
     *
     * @param sysRole 角色信息
     * @return 角色信息集合
     */
    public List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 新增角色信息
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    public int insertSysRole(SysRole sysRole);

    /**
     * 修改角色信息
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    public int updateSysRole(SysRole sysRole);

    /**
     * 批量删除角色信息
     *
     * @param roleIds 需要删除的角色信息主键集合
     * @return 结果
     */
    public int deleteSysRoleByRoleIds(Long[] roleIds);

    /**
     * 删除角色信息信息
     *
     * @param roleId 角色信息主键
     * @return 结果
     */
    public int deleteSysRoleByRoleId(Long roleId);
}
