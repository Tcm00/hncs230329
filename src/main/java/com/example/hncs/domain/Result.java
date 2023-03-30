package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * resultInfo对象 result
 *
 * @author tangcanming
 * @date 2023-03-30
 */
@Data
@ApiModel(value = "result",description = "成绩信息")
public class Result {
    private static final long serialVersionUID = 1L;

    /**
     * key
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 课程名称
     */
    //@Excel(name = "课程名称")
    @ApiModelProperty(name = "classname", value = "课程名称", example = "MySQL")
    private String classname;

    /**
     * 成绩
     */
    //@Excel(name = "成绩")
    @ApiModelProperty(name = "result", value = "成绩", example = "95")
    private Long result;

    /**
     * 考试时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "testtime", value = "考试时间", example = "2023-03-29")
    //@Excel(name = "考试时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testtime;

    /**
     * 班级id
     */
    //@Excel(name = "班级id")
    @ApiModelProperty(name = "classid", value = "班级id", example = "11")
    private Long classid;

    /**
     * 用户id
     */
    //@Excel(name = "用户id")
    @ApiModelProperty(name = "userid", value = "用户id", example = "215223650218")
    private Long userid;

    /**
     * 是否删除,0否，1是
     */
    //@Excel(name = "是否删除,0否，1是")
    @ApiModelProperty(name = "isdel", value = "是否删除", example = "0")
    private Integer isdel;

    /**
     * 操作者id
     */
    //@Excel(name = "操作者id")
    @ApiModelProperty(name = "creatid", value = "操作者id")
    private Long creatid;

    /**
     * 班主任
     */
    //@Excel(name = "班主任")
    @TableField(exist = false)
    @ApiModelProperty(name = "teachername", value = "班主任", example = "李华")
    private String teachername;

    /**
     * 建立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    //@Excel(name = "建立时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(name = "creattime", value = "创建时间", example = "2023-03-29")
    private Date creattime;

}
