package com.anuouan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Title User
 * @Author: anuouan
 * @Date: 2024/12/10 12:50
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
