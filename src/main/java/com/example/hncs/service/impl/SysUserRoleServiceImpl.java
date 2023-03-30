package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.SysUserRole;
import com.example.hncs.mapper.SysUserRoleMapper;
import com.example.hncs.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户和角色关联Service业务层处理
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Service
public class SysUserRoleServiceImpl  extends ServiceImpl<SysUserRoleMapper,SysUserRole> implements ISysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询用户和角色关联
     *
     * @param userId 用户和角色关联主键
     * @return 用户和角色关联
     */
    @Override
    public SysUserRole selectSysUserRoleByUserId(Long userId) {
        return sysUserRoleMapper.selectSysUserRoleByUserId(userId);
    }

    /**
     * 查询用户和角色关联列表
     *
     * @param sysUserRole 用户和角色关联
     * @return 用户和角色关联
     */
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole) {
        return sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
    }

    /**
     * 新增用户和角色关联
     *
     * @param sysUserRole 用户和角色关联
     * @return 结果
     */
    @Override
    public int insertSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insertSysUserRole(sysUserRole);
    }

    /**
     * 修改用户和角色关联
     *
     * @param sysUserRole 用户和角色关联
     * @return 结果
     */
    @Override
    public int updateSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 批量删除用户和角色关联
     *
     * @param userIds 需要删除的用户和角色关联主键
     * @return 结果
     */
    @Override
    public int deleteSysUserRoleByUserIds(Long[] userIds) {
        return sysUserRoleMapper.deleteSysUserRoleByUserIds(userIds);
    }

    /**
     * 删除用户和角色关联信息
     *
     * @param userId 用户和角色关联主键
     * @return 结果
     */
    @Override
    public int deleteSysUserRoleByUserId(Long userId) {
        return sysUserRoleMapper.deleteSysUserRoleByUserId(userId);
    }
}
