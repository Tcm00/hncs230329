package com.example.hncs.domain;

import lombok.Getter;

/**
 * @author 小明
 * @date 2023/3/29
 * @description
 */
public enum BaseEnum {

    ZERO_INT(0,"字符串0"),

    ONE_INT(1,"字符串1");

    BaseEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private int code;



    @Getter
    private String name;

}
