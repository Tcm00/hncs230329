package com.example.hncs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * classInfo对象 class
 *
 * @author hncs
 * @date 2023-03-29
 */
@Data
@TableName(value = "class")
@ApiModel(value = "class", description = "班级信息")
public class ClassInfo {
    private static final long serialVersionUID = 1L;

    /**
     * key
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 班级名
     */
    //@Excel(name = "班级名")
    @ApiModelProperty(name = "classname", value = "班级名", example = "")
    private String classname;

    /**
     * 班主任
     */
    //@Excel(name = "班主任")
    @ApiModelProperty(name = "teachername", value = "班主任", example = "")
    private String teachername;

    /**
     * 建立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "creattime", value = "建立时间", example = "")
    //@Excel(name = "建立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creattime;

    /**
     * 是否删除,0是，1否
     */
    //@Excel(name = "是否删除,0是，1否")
    @ApiModelProperty(name = "isdel", value = "是否删除", example = "")
    private Integer isdel;

    /**
     * 创建者id
     */
    //@Excel(name = "创建者id")
    @ApiModelProperty(name = "creatid", value = "创建者id", example = "")
    private Long creatid;

}
