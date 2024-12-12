package com.anuouan.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.json.JSONObject;
import com.anuouan.tools.R;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Title UploadDemoController
 * @Author: anuouan
 * @Date: 2024/12/11 13:10
 * @Version: v1.0.0
 * @Description: TODO
 **/
@RestController
public class UploadDemoController {

    @Value("${dromara.x-file-storage.minio[0].end-point}")
    private String host;

    @Value("${dromara.x-file-storage.minio[0].bucket-name}")
    private String bucketName;
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("file = " + file);
        StrBuilder sb = new StrBuilder();
        String newPath = sb.append(DateTime.now().toString("yyyyMMdd")).append("/").toString();
        String newFileName = sb.clear().append(DateTime.now().toString("yyyyMMddHHmmss")).append(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'))).toString();

        FileInfo fileInfo = fileStorageService.of(file)
                .setPath(newPath)
                .setSaveFilename(newFileName)
                .upload();

        String newPathView = sb.clear().append(host).append("/").append(bucketName).append("/").append(newPath).append(newFileName).toString();
        System.out.println("newPathView = " + newPathView);

        boolean b = fileInfo != null ? true : false;
        System.out.println("b = " + b);

        return R.success(newPathView);
    }
}
