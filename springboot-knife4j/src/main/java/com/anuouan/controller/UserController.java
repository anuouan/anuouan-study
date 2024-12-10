package com.anuouan.controller;

import com.anuouan.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Title UserController
 * @Author: anuouan
 * @Date: 2024/12/10 14:30
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Tag(name = "用户管理", description = "用户相关操作")
@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(summary = "获取用户列表", description = "返回所有用户的列表")
    @GetMapping("/getUsers1")
    public List<User> getUsers1() {
        // ...
        return null;
    }

    @Operation(summary = "获取用户列表")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "请求参数错误"),
            @ApiResponse(responseCode = "404", description = "找不到资源"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    @GetMapping("/getUsers2")
    public List<User> getUsers2() {
        // ...
        return null;
    }

    @Operation(summary = "获取用户详情")
    @GetMapping("/{id}")
    public User getUser3(@Parameter(description = "用户ID", required = true) @PathVariable Long id) {
        // ...
        return null;
    }

    @Operation(summary = "分页获取用户列表")
    @Parameters({
            @Parameter(name = "page", description = "页码", required = true, schema = @Schema(type = "integer", example = "1")),
            @Parameter(name = "size", description = "每页数量", required = true, schema = @Schema(type = "integer", example = "10"))
    })
    @GetMapping("/getUsersByPage")
    public List<User> getUsersByPage(@RequestParam int page, @RequestParam int size) {
        // ...
        return null;
    }


    @Operation(summary = "上传文件")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@Parameter(description = "文件", required = true) @RequestParam("file") MultipartFile file) {
        // ...
        return null;
    }





}
