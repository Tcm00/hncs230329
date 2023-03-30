package com.example.hncs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hncs.domain.Result;
import com.example.hncs.domain.ResultBody;
import com.example.hncs.domain.SysRole;
import com.example.hncs.domain.User;

import java.util.List;

/**
 * userService接口
 *
 * @author tangcanming
 * @date 2023-03-29
 */
public interface IUserService extends IService<User> {
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
    public List<User> selectUserList(User user, User sysUser);

    /**
     * 查询user列表-分页
     *
     * @param user user
     * @return user集合
     */
    public ResultBody selectUserListPage(Page<User> page, User user, User sysUser);

    /**
     * 新增user
     *
     * @param user user
     * @return 结果
     */
    public ResultBody insertUser(User user) throws Exception;

    /**
     * 修改user
     *
     * @param user user
     * @return 结果
     */
    public ResultBody updateUser(User user,User sysUser);

    /**
     * 批量删除user
     *
     * @param ids 需要删除的user主键集合
     * @return 结果
     */
    public ResultBody deleteUserByIds(Long[] ids);

    /**
     * 删除user信息
     *
     * @param id user主键
     * @return 结果
     */
    public int deleteUserById(Long id);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    ResultBody getUser(User user) throws Exception;


    /**
     * 发送邮件
     * @param email
     * @return
     */
    ResultBody sendEmail(String email);

    /**
     * 查询我的信息+角色
     * @param sysUser
     */
    List<SysRole> getInfo(User sysUser);

    /**
     * 查询自己信息
     * @param sysUser
     * @return
     */
    List<Result> getInfoByClass(User sysUser);
}
