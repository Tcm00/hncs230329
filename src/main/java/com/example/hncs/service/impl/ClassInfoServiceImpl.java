package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.*;
import com.example.hncs.mapper.ClassInfoMapper;
import com.example.hncs.service.IClassInfoService;
import com.example.hncs.service.ISysUserRoleService;
import com.example.hncs.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * classInfoService业务层处理
 *
 * @author hncs
 * @date 2023-03-29
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper,ClassInfo> implements IClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 查询classInfo
     *
     * @param id classInfo主键
     * @return classInfo
     */
    @Override
    public ClassInfo selectClassById(Long id) {
        return classInfoMapper.selectClassById(id);
    }

    /**
     * 查询classInfo列表
     *
     * @param classInfo classInfo
     * @return classInfo
     */
    @Override
    public List<ClassInfo> selectClassList(ClassInfo classInfo) {
        return classInfoMapper.selectClassList(classInfo);
    }

    /**
     * 查询classInfo列表
     *
     * @param classInfo classInfo
     * @return classInfo
     */
    @Override
    public ResultBody selectClassListPage(Page<ClassInfo> page, ClassInfo classInfo) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            ResultBody.error().message("仅管理员可以查询所有用户信息");
        }
        return ResultBody.ok().data("classInfo",classInfoMapper.selectClassListPage(page,classInfo.getId(),classInfo.getClassname(),classInfo.getTeachername()));
    }


    /**
     * 新增classInfo
     *
     * @param classInfo classInfo
     * @return 结果
     */
    @Override
    public int insertClass(ClassInfo classInfo) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            ResultBody.error().message("仅管理员可以新增课程信息");
        }
        return classInfoMapper.insertClass(classInfo);
    }

    /**
     * 修改classInfo
     *
     * @param classInfo classInfo
     * @return 结果
     */
    @Override
    public int updateClass(ClassInfo classInfo) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            ResultBody.error().message("仅管理员可以修改课程信息");
        }
        return classInfoMapper.updateClass(classInfo);
    }

    /**
     * 批量删除classInfo
     *
     * @param ids 需要删除的classInfo主键
     * @return 结果
     */
    @Override
    public int deleteClassByIds(Long[] ids) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            ResultBody.error().message("仅管理员可以删除课程信息");
        }
        return classInfoMapper.deleteClassByIds(ids);
    }

    /**
     * 删除classInfo信息
     *
     * @param id classInfo主键
     * @return 结果
     */
    @Override
    public int deleteClassById(Long id) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            ResultBody.error().message("仅管理员可以删除信息");
        }
        return classInfoMapper.deleteClassById(id);
    }
}
