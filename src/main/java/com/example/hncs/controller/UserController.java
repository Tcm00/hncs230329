package com.example.hncs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hncs.domain.*;
import com.example.hncs.service.IUserService;
import com.example.hncs.utils.LocalUser;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * userController
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Api(tags = "用户管理信息")
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "发送邮箱验证码")
    @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String", required = true, example = "xxxx@qq.com")
    @PostMapping("/sendEmail")
    public ResultBody sendEmail(@RequestParam String email) {
        return userService.sendEmail(email);
    }

    /**
     * 查询user列表
     */
    //@PreAuthorize("@ss.hasPermi('system:user:list')")
    @ApiOperation(value = "管理员查看所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber",value = "当前页数(默认1)",dataType = "Long",example = "1"),
            @ApiImplicitParam(name = "size",value = "每页容量(默认10)",dataType = "Long",example = "10"),
    })
    @GetMapping("/list")
    public ResultBody list(@RequestParam(defaultValue = "1") @NotEmpty Long pageNumber,
                           @RequestParam(defaultValue = "1") @NotEmpty Long size,
                           User user) {
        User sysUser = LocalUser.USER.get();
        Page<User> Page = new Page<>(pageNumber, size);

        return userService.selectUserListPage(Page,user, sysUser);
    }

    /**
     * 查询自己的信息
     */
    //@PreAuthorize("@ss.hasPermi('system:user:list')")
    @ApiOperation(value = "查询自己的信息")
    @GetMapping("/getInfo")
    public ResultBody getInfo() {
        User sysUser = LocalUser.USER.get();
        List<SysRole> roles = userService.getInfo(sysUser);
        List<Result> infoByClass = userService.getInfoByClass(sysUser);
        return ResultBody.ok().data("sysUser", sysUser).data("roles", roles).data("infoByClass", infoByClass);
    }

    /**
     * 导出user列表
     */
    //@PreAuthorize("@ss.hasPermi('system:user:export')")
    ////@Log(title = "user", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, User user) {
//        List<User> list = userService.selectUserList(user);
//        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
//        util.exportExcel(response, list, "user数据");
//    }

    /**
     * 获取user详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:user:query')")
    @ApiOperation(value = "根据id查用户信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(userService.selectUserById(id));
    }

    /**
     * 注册接口
     */
    //@PreAuthorize("@ss.hasPermi('system:user:add')")
    //@Log(title = "user", businessType = BusinessType.INSERT)
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResultBody add(@RequestBody @ApiParam User user, HttpServletRequest request) throws Exception {

        return userService.insertUser(user);
    }

    @ApiOperation(value = "用户登录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "isUser [0:管理员，1：用户]  新注册用户默认为普通用户")
    })
    @PostMapping("/login")
    public ResultBody login(@RequestBody @ApiParam User user) throws Exception {
        return userService.getUser(user);
    }

    /**
     * 修改user
     */
    //@PreAuthorize("@ss.hasPermi('system:user:edit')")
    //@Log(title = "user", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改用户信息")
    @PutMapping
    public ResultBody edit(@RequestBody @ApiParam User user) {
        User sysUser = LocalUser.USER.get();
        return userService.updateUser(user, sysUser);
    }

    /**
     * 删除user
     */
    //@PreAuthorize("@ss.hasPermi('system:user:remove')")
    //@Log(title = "user", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除用户信息")
    @DeleteMapping("/{ids}")
    public ResultBody remove(@PathVariable Long[] ids) {
        return userService.deleteUserByIds(ids);
    }
}
