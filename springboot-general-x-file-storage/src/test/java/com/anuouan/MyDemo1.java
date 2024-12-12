package com.anuouan;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageProperties;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.ProgressListener;
import org.dromara.x.file.storage.core.constant.Constant;
import org.dromara.x.file.storage.core.hash.HashInfo;
import org.dromara.x.file.storage.core.presigned.GeneratePresignedUrlPretreatment;
import org.dromara.x.file.storage.core.presigned.GeneratePresignedUrlResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title MyDemo1
 * @Author: anuouan
 * @Date: 2024/12/12 14:17
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Slf4j
@SpringBootTest
public class MyDemo1 {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    public void test5() {
        boolean exists = fileStorageService.exists("http://localhost:9000/demo/20241212/20241212210306.jpg");
//        boolean exists = fileStorageService.exists("/20241212/20241212210306.jpg");
        System.out.println("exists = " + exists);
    }
    @Test
    public void test4() {
        FileInfo url = fileStorageService.getFileInfoByUrl("http://localhost:9000/demo/20241212/20241212183351.jpg");
        System.out.println("url = " + url);
    }
    @Test
    public void test3() {
//        String s = "http://localhost:9000/demo/20241212/20241212180908.jpg";
        String s = "/20241212/20241212180908.jpg";
        String bucketName = fileStorageService.getProperties().getMinio().get(0).getBucketName();
        String substring = s.substring(s.indexOf(bucketName) + bucketName.length() + 1);
        System.out.println("substring = " + substring);
    }

    /**
     * @Author anuouan
     * @Param null
     * @Return void
     * @Date 2024/12/12 14:25
     * @Description 删除图片
     */
    @Test
    public void test2() {

        boolean delete = fileStorageService.delete("http://localhost:9000/demo/20241212/20241212183351.jpg");
        System.out.println("delete = " + delete);

    }

    /**
     * @Author anuouan
     * @Param null
     * @Return void
     * @Date 2024/12/12 14:25
     * @Description 上传图片
     */
    @Test
    public void test1() {
        String filename = "image.jpg";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);

        //设置新路径和重新命名文件
        StrBuilder sb = new StrBuilder();
        String newPath = sb.clear().append(DateTime.now().toString("yyyyMMdd")).append("/").toString();
        String newFileName = sb.clear().append(DateTime.now().toString("yyyyMMddHHmmss")).append(filename.substring(filename.lastIndexOf('.'))).toString();

        FileInfo fileInfo = fileStorageService.of(in)
                .setPath(newPath)
                .setSaveFilename(newFileName)
                .upload();


//        boolean exists = fileStorageService.exists(fileInfo.getUrl());
//        System.out.println("exists = " + exists);


//        String presignedUrl = fileStorageService
//                .generatePresignedUrl(fileInfo, DateUtil.offsetHour(new Date(), 1));

        FileStorageProperties.MinioConfig minioConfig = fileStorageService.getProperties().getMinio().get(0);
        System.out.println("fileInfo = " + fileInfo);
        System.out.println("minioConfig = " + minioConfig);
//        String result = new GeneratePresignedUrlPretreatment().setPath(fileInfo.getPath()).setFilename(fileInfo.getFilename()).setMethod("GET").generatePresignedUrl().getUrl();
//        System.out.println("result = " + result);
//        System.out.println("文件授权访问地址：" + presignedUrl);
        System.out.println("minioConfig.getEndPoint() = " + minioConfig.getEndPoint());
        System.out.println("minioConfig.getBucketName() = " + minioConfig.getBucketName());
        String s = sb.clear()
                .append(minioConfig.getEndPoint())
                .append("/")
                .append(minioConfig.getBucketName())
                .append("/")
                .append(fileInfo.getUrl()).toString();

//        boolean delete = fileStorageService.delete("demo/20241212/20241212153754.jpg");
//        System.out.println("delete = " + delete);
        System.out.println("sb = " + s);

    }
}
