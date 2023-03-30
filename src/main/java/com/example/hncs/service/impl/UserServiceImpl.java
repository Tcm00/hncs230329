package com.example.hncs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hncs.domain.*;
import com.example.hncs.mapper.UserMapper;
import com.example.hncs.service.IResultService;
import com.example.hncs.service.ISysRoleService;
import com.example.hncs.service.ISysUserRoleService;
import com.example.hncs.service.IUserService;
import com.example.hncs.utils.JWTUtil;
import com.example.hncs.utils.LocalUser;
import com.example.hncs.utils.MD5Util;
import io.netty.util.internal.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * userService业务层处理
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private IResultService resultService;

    /**
     * 查询user
     *
     * @param id user主键
     * @return user
     */
    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 查询user列表
     *
     * @param user user
     * @return user
     */
    @Override
    public ResultBody selectUserListPage(Page<User> page,User user, User sysUser) {
        //超级管理员+可以查看所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0) {
            ResultBody.error().message("仅管理员可以查询所有用户信息");
        }
        return ResultBody.ok().data("userList",userMapper.selectUserListPage(page, user.getUsername(),user.getPassword(),user.getTruename(),user.getAdress(),user.getSex()));
    }
    /**
     * 查询user列表
     *
     * @param user user
     * @return user
     */
    @Override
    public List<User> selectUserList(User user, User sysUser) {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增user
     *
     * @param user user
     * @return 结果
     */
    @Override
    public ResultBody insertUser(User user) throws Exception {
        //验证码
        if (StringUtil.isNullOrEmpty(user.getUsername())) {
            return ResultBody.error().message("注册失败：用户名不能为空");
        }
        String code = redisTemplate.opsForValue().get(user.getAdress());
        if (code == null) {
            return ResultBody.error().message("请先获取验证码");
        }
        if (!user.getEmailCode().equals(code)) {
            System.out.println(redisTemplate.opsForValue().get(user.getUsername()));
            return ResultBody.error().message("验证码错误");
        }
        User userTemp = new User();
        userTemp.setUsername(user.getUsername());
        userTemp.setIsdel(0);
        userTemp.setIsuse(0);
        List<User> users = userMapper.selectUserList(userTemp);
        if (users.size() > 0) {
            return ResultBody.error().message("注册失败：该用户已存在");
        }
        String s = MD5Util.md5(user.getPassword());
        user.setPassword(s);
        user.setIsdel(0);
        user.setIsuse(0);
        return userMapper.insertUser(user) > 0 ? ResultBody.ok().message("注册成功") : ResultBody.error().message("注册失败");
    }

    /**
     * 超级管理 可以修改user
     *
     * @param user user
     * @return 结果
     */
    @Override
    public ResultBody updateUser(User user,User sysUser) {
        //超级管理员+可以编辑所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0 && !sysUser.getId().equals(user.getId())) {
            ResultBody.error().message("仅管理员可以编辑他的信息");
        }
        return userMapper.updateUser(user) > 0 ? ResultBody.ok().message("修改成功"):ResultBody.error().message("修改失败");
    }

    /**
     * 批量删除user
     *
     * @param ids 需要删除的user主键
     * @return 结果
     */
    @Override
    public ResultBody deleteUserByIds(Long[] ids) {
        User sysUser = LocalUser.USER.get();
        //超级管理员+可以编辑所有
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId())
                .eq(SysUserRole::getRoleId, BaseEnum.ONE_INT.getCode());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        if (list.size() == 0 ) {
            return ResultBody.error().message("仅管理员可以删除用户信息");
        }
        return userMapper.deleteUserByIds(ids) > 0 ? ResultBody.ok().message("删除成功"):ResultBody.error().message("删除失败");
    }

    /**
     * 删除user信息
     *
     * @param id user主键
     * @return 结果
     */
    @Override
    public int deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public ResultBody getUser(User user) throws Exception {
        if (StringUtil.isNullOrEmpty(user.getUsername())) {
            return ResultBody.error().message("请输入用户名");
        }
        if (StringUtil.isNullOrEmpty(user.getPassword())) {
            return ResultBody.error().message("请输入密码");
        }
        String pwd = MD5Util.md5(user.getPassword());
        user.setPassword(pwd);
        user.setIsdel(BaseEnum.ZERO_INT.getCode());
        user.setIsdel(BaseEnum.ZERO_INT.getCode());
        List<User> users = userMapper.selectUserList(user);
        if (users.size() > 1) {
            return ResultBody.error().message("存在多个相同账号的用户，请联系管理员排查");
        }
        if (users.size() == 0) {
            return ResultBody.error().message("未找到对应的用户:" + user.getUsername());
        }
        user = users.get(0);
        try {
            if (!user.toString().isEmpty()) {
                HashMap<String, Object> map = new HashMap<>();
                try {
                    HashMap<String, String> payload = new HashMap<>();
                    payload.put("id", String.valueOf(user.getId()));
                    payload.put("username", user.getUsername());
                    payload.put("password", user.getPassword());
                    payload.put("sex", String.valueOf(user.getSex()));
                    payload.put("adress", user.getAdress());
                    payload.put("remark", String.valueOf(user.getRemark()));
                    //生成JWT令牌
                    String token = JWTUtil.getToken(payload);
                    map.put("state", true);
                    map.put("msg", "认证成功");
                    //响应token
                    map.put("token", token);
                } catch (Exception e) {
                    map.put("state", false);
                    map.put("msg", e.getMessage());
                    e.printStackTrace();
                }
                return ResultBody.ok().data("info", users.get(0)).data("token", map).message("登录成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultBody sendEmail(String email) {
        String code = String.valueOf(Math.random()).substring(2, 8);
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("验证码");
        message.setText(code);
        message.setTo(email);
        message.setFrom("1743394547@qq.com");
        javaMailSender.send(message);
        redisTemplate.opsForValue().set(email, code);
        return ResultBody.ok().message("发送邮件成功:" + code);
    }

    /**
     * 获取角色信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<SysRole> getInfo(User sysUser) {
        LambdaQueryWrapper<SysUserRole> lambda = new QueryWrapper<SysUserRole>().lambda();
        LambdaQueryWrapper<SysUserRole> eq = lambda.eq(SysUserRole::getUserId, sysUser.getId());
        List<SysUserRole> list = sysUserRoleService.list(eq);
        List<Long> roleIds = list.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        if (roleIds.size() == 0) {
            return null;
        }
        return sysRoleService.list(new QueryWrapper<SysRole>().lambda().in(SysRole::getRoleId, roleIds).eq(SysRole::getDelFlag, 0));
    }

    /**
     * 获取学科-成绩信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<Result> getInfoByClass(User sysUser) {
        return resultService.getClassByRes(sysUser);
    }
}
