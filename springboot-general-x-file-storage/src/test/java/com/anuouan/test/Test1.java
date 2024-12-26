package com.anuouan.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.crypto.SecureUtil;
import com.sun.media.sound.DataPusher;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.*;
import org.dromara.x.file.storage.core.constant.Constant;
import org.dromara.x.file.storage.core.hash.HashInfo;
import org.dromara.x.file.storage.core.platform.FileStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class Test1 {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    void test1() {
        //获取项目根路径
        System.out.println(System.getProperty("user.dir"));
        // 定义日期时间格式

//         获取东八区的时间
//        GMT+8

//        配置时间
        DateTime now = DateTime.now();
        System.out.println(now.toString(DatePattern.PURE_DATETIME_MS_FORMAT));
        //20241225212553386
        System.out.println(now.toString(DatePattern.PURE_DATE_FORMAT));
        //20241225


    }

    /**
     * 单独对文件上传进行测试
     */
    @Test
    public void upload() {

        String endPoint = fileStorageService.getProperties().getMinio().get(0).getEndPoint();
        String bucketName = fileStorageService.getProperties().getMinio().get(0).getBucketName();
        System.out.println("endPoint = " + endPoint);
        System.out.println("bucketName = " + bucketName);


    }

    @Test
    public void test2() {
        String fileName = DateTime.now().toString(DatePattern.PURE_DATETIME_MS_FORMAT);
        String bucketName = DateTime.now().toString(DatePattern.PURE_DATE_FORMAT);
        System.out.println(fileName);
        System.out.println(bucketName);

    }
    /**
     * 测试根据 url 上传文件
     */
    @Test
    public void uploadByURL() throws IOException {

        String url = "https://www.xuyanwu.cn/file/upload/1566046282790-1.png";

        String fileName = DateTime.now().toString(DatePattern.PURE_DATETIME_MS_FORMAT);
        String bucketName = DateTime.now().toString(DatePattern.PURE_DATE_FORMAT);

        StrBuilder sb = StrBuilder.create();
        sb.append(fileName).append(".png");
        FileInfo fileInfo = fileStorageService
                .of(url)
                .setPath(bucketName+"/")//设置文件路径
                .setSaveFilename(sb.toString())//设置保存文件名
//                .setSaveThFilename(sb.toString())//设置保存缩略图文件名
                .setThContentType("image/png")//设置缩略图文件类型

//                .thumbnail()//开启缩略图
//                .setPath("test/")
                .setObjectId("0")
                .setObjectType("0")
                .upload();
        Assert.notNull(fileInfo, "文件上传失败！");
        log.info("文件上传成功：{}", fileInfo.toString());
    }
}
