package com.example.hncs.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hncs.domain.ClassInfo;
import com.example.hncs.domain.Result;
import com.example.hncs.domain.User;

/**
 * resultInfoMapper接口
 * 
 * @author tangcanming
 * @date 2023-03-30
 */
public interface ResultMapper  extends BaseMapper<Result>
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
    public List<Result> selectResultList(Result result);

    /**
     * 查询resultInfo列表
     *
     * @param result resultInfo
     * @return resultInfo集合
     */
    Page<Result> selectResultListPage(Page<Result> page, String classname, String teachername, Long classid, Long userid);

    /**
     * 新增resultInfo
     * 
     * @param result resultInfo
     * @return 结果
     */
    public int insertResult(Result result);

    /**
     * 修改resultInfo
     * 
     * @param result resultInfo
     * @return 结果
     */
    public int updateResult(Result result);

    /**
     * 删除resultInfo
     * 
     * @param id resultInfo主键
     * @return 结果
     */
    public int deleteResultById(Long id);

    /**
     * 批量删除resultInfo
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteResultByIds(Long[] ids);

    List<Result> getClassByRes(Long userId);


}
