package com.example.hncs.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hncs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * userMapper接口
 *
 * @author tangcanming
 * @date 2023-03-29
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询user
     *
     * @param id user主键
     * @return user
     */
    public User selectUserById(Long id);

    /**
     * 查询user列表
     *
     * @param user user
     * @return user集合
     */
    public List<User> selectUserList(User user);

    /**
     * 查询user列表 分页
     *
     * @param user user
     * @return user集合
     */
    public Page<User> selectUserListPage(Page<User> page, String username, String password, String truename, String adress,Integer sex);

    /**
     * 新增user
     *
     * @param user user
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改user
     *
     * @param user user
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除user
     *
     * @param id user主键
     * @return 结果
     */
    public int deleteUserById(Long id);

    /**
     * 批量删除user
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);

}
