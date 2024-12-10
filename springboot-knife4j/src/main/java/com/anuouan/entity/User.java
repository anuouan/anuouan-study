package com.anuouan.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "用户实体")
public class User {
    @Schema(description = "用户账号", example = "字符串")
    private String username;
    @Schema(description = "用户密码", example = "6位")
    private String password;
}
