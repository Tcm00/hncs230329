package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.*;
import com.example.hncs.mapper.ResultMapper;
import com.example.hncs.service.IResultService;
import com.example.hncs.service.ISysUserRoleService;
import com.example.hncs.utils.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * resultInfoService业务层处理
 *
 * @author tangcanming
 * @date 2023-03-30
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result> implements IResultService {
    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 查询resultInfo
     *
     * @param id resultInfo主键
     * @return resultInfo
     */
    @Override
    public Result selectResultById(Long id) {
        return resultMapper.selectResultById(id);
    }

    /**
     * 查询resultInfo列表
     *
     * @param result resultInfo
     * @return resultInfo
     */
    @Override
    public ResultBody selectResultListPage(Page<Result> page , Result result) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            return ResultBody.error().message("仅管理员可以查询所有成绩信息");
        }
        Page<Result> results = resultMapper.selectResultListPage(page,result.getClassname(),result.getTeachername(),result.getClassid(),result.getUserid());
        return ResultBody.ok().data("results",results);
    }
    /**
     * 查询resultInfo列表
     *
     * @param result resultInfo
     * @return resultInfo
     */
    @Override
    public ResultBody selectResultList(Result result) {
        List<Result> results = resultMapper.selectResultList(result);
        return ResultBody.ok().data("results",results);
    }
    /**
     * 新增resultInfo
     *
     * @param result resultInfo
     * @return 结果
     */
    @Override
    public ResultBody insertResult(Result result) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            return ResultBody.error().message("仅管理员可以新增成绩信息");
        }
        result.setIsdel(0);

        return resultMapper.insertResult(result) > 0 ? ResultBody.ok().message("新增成功") : ResultBody.error().message("新增失败");
    }

    /**
     * 修改resultInfo
     *
     * @param result resultInfo
     * @return 结果
     */
    @Override
    public ResultBody updateResult(Result result) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0 && !sysUser.getId().equals(result.getId())) {
            return ResultBody.error().message("仅管理员可以编辑他人信息");
        }
        return resultMapper.updateResult(result) > 0 ? ResultBody.ok().message("修改成功") : ResultBody.error().message("修改失败");
    }

    /**
     * 批量删除resultInfo
     *
     * @param ids 需要删除的resultInfo主键
     * @return 结果
     */
    @Override
    public int deleteResultByIds(Long[] ids) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以删除
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0 ) {
            return 0;
        }
        return resultMapper.deleteResultByIds(ids);
    }

    /**
     * 删除resultInfo信息
     *
     * @param id resultInfo主键
     * @return 结果
     */
    @Override
    public int deleteResultById(Long id) {
        return resultMapper.deleteResultById(id);
    }

    @Override
    public List<Result> getClassByRes(User sysUser) {
        return resultMapper.getClassByRes(sysUser.getId());
    }
}
