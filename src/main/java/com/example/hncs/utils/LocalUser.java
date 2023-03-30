package com.example.hncs.utils;

import com.example.hncs.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author 小明
 * @date 2021/10/27
 * @description
 */
@Component
public class LocalUser {
    public static ThreadLocal<User> USER = new ThreadLocal<>();
}
