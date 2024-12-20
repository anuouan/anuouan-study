package com.anuouan.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title User
 * @Author: anuouan
 * @Date: 2024/12/20 12:35
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private String address;
}
