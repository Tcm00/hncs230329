package com.example.hncs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hncs.domain.ClassInfo;
import com.example.hncs.domain.ResultBody;
import com.example.hncs.domain.User;

import java.util.List;

/**
 * classInfoService接口
 *
 * @author hncs
 * @date 2023-03-29
 */
public interface IClassInfoService extends IService<ClassInfo> {
    /**
     * 查询classInfo
     *
     * @param id classInfo主键
     * @return classInfo
     */
    public ClassInfo selectClassById(Long id);

    /**
     * 查询classInfo列表
     *
     * @param classInfo classInfo
     * @return classInfo集合
     */
    public List<ClassInfo> selectClassList(ClassInfo classInfo);

    /**
     * 新增classInfo
     *
     * @param classInfo classInfo
     * @return 结果
     */
    public int insertClass(ClassInfo classInfo);

    /**
     * 修改classInfo
     *
     * @param classInfo classInfo
     * @return 结果
     */
    public int updateClass(ClassInfo classInfo);

    /**
     * 批量删除classInfo
     *
     * @param ids 需要删除的classInfo主键集合
     * @return 结果
     */
    public int deleteClassByIds(Long[] ids);

    /**
     * 删除classInfo信息
     *
     * @param id classInfo主键
     * @return 结果
     */
    public int deleteClassById(Long id);

    ResultBody selectClassListPage(Page<ClassInfo> page, ClassInfo classInfo);
}
