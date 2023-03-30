package com.example.hncs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hncs.domain.ClassInfo;
import com.example.hncs.domain.User;

import java.util.List;

/**
 * classInfoMapper接口
 *
 * @author hncs
 * @date 2023-03-29
 */
public interface ClassInfoMapper  extends BaseMapper<ClassInfo> {
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
     * 删除classInfo
     *
     * @param id classInfo主键
     * @return 结果
     */
    public int deleteClassById(Long id);

    /**
     * 批量删除classInfo
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassByIds(Long[] ids);

    Page<ClassInfo> selectClassListPage(Page<ClassInfo> page, Long id, String classname, String teachername);
}
