package com.example.hncs.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hncs.domain.Result;
import com.example.hncs.domain.ResultBody;
import com.example.hncs.domain.User;

/**
 * resultInfoService接口
 * 
 * @author tangcanming
 * @date 2023-03-30
 */
public interface IResultService extends IService<Result>
{
    /**
     * 查询resultInfo
     * 
     * @param id resultInfo主键
     * @return resultInfo
     */
    public Result selectResultById(Long id);

    /**
     * 查询resultInfo列表
     * 
     * @param result resultInfo
     * @return resultInfo集合
     */
    public ResultBody selectResultListPage(Page<Result> page, Result result);

    /**
     * 查询resultInfo列表
     *
     * @param result resultInfo
     * @return resultInfo集合
     */
    public ResultBody selectResultList(Result result);

    /**
     * 新增resultInfo
     * 
     * @param result resultInfo
     * @return 结果
     */
    public ResultBody insertResult(Result result);

    /**
     * 修改resultInfo
     * 
     * @param result resultInfo
     * @return 结果
     */
    public ResultBody updateResult(Result result);

    /**
     * 批量删除resultInfo
     * 
     * @param ids 需要删除的resultInfo主键集合
     * @return 结果
     */
    public int deleteResultByIds(Long[] ids);

    /**
     * 删除resultInfo信息
     * 
     * @param id resultInfo主键
     * @return 结果
     */
    public int deleteResultById(Long id);

    List<Result> getClassByRes(User sysUser);
}
