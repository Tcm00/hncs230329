package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * user对象 user
 *
 * @author tangcanming
 * @date 2023-03-29
 */
@Data
@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名，英文字符开头，可含数字
     */
    //@Excel(name = "用户名，英文字符开头，可含数字")
    @ApiModelProperty(name = "username", value = "用户名", example = "15223650215")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码，md5值
     */
    //@Excel(name = "密码，md5值")
    @ApiModelProperty(name = "password", value = "密码", example = "123")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 真实姓名
     */
    //@Excel(name = "真实姓名")
    @ApiModelProperty(name = "truename", value = "真实姓名", example = "1234")
    @NotBlank(message = "真实姓名不能为空")
    private String truename;

    /**
     * 性别，0男，1女
     */
    //@Excel(name = "性别，0男，1女")
    @ApiModelProperty(name = "sex", value = "性别", example = "0")
    private Integer sex;

    /**
     * 邮箱地址
     */
    //@Excel(name = "地址")
    @ApiModelProperty(name = "adress", value = "地址", example = "1743394547@qq.com")
    private String adress;

    /**
     * 是否删除，0否，1是
     */
    //@Excel(name = "是否删除，0否，1是")
    @ApiModelProperty(name = "isdel", value = "是否删除", example = "0")
    private Integer isdel;

    /**
     * 是否禁用，0否，1是
     */
    //@Excel(name = "是否禁用，0否，1是")
    @ApiModelProperty(name = "isuse", value = "是否禁用", example = "0")
    private Integer isuse;

    /**
     * 备注
     */
    //@Excel(name = "备注")
    @ApiModelProperty(name = "remark", value = "备注", example = "789")
    private String remark;

    @ApiModelProperty(name = "emailCode", value = "邮箱验证码", example = "0")
    @TableField(exist = false)
    private String emailCode;

}
