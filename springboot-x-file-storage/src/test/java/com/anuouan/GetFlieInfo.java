package com.anuouan;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.unit.DataUnit;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

/**
 * @Title GetFlieInfo
 * @Author: anuouan
 * @Date: 2024/12/11 9:36
 * @Version: v1.0.0
 * @Description: TODO
 **/
@EnableFileStorage
@SpringBootTest
public class GetFlieInfo {
    @Value("${dromara.x-file-storage.minio[0].end-point}")
    private String endPoint;
    @Autowired
    private FileStorageService fileStorageService;//注入实列

    @Test
    void test1(){
        System.out.println(System.getProperty("user.dir"));
        DateTime now = DateTime.now();
        System.out.println("now = " + now);
        String yyyyMMDDHHmmss = now.toString("yyyyMMDDHHmmss");
        System.out.println("yyyyMMDDHHmmss = " + yyyyMMDDHHmmss);

    }
    @Test
    void test2(){

        String a = "1.jpg";
        String suffix = a.substring(a.lastIndexOf('.'));
        System.out.println("suffix = " + suffix);

    }
    @Test
    void test3(){
        System.out.println("endPoint = " + endPoint);
    }
}
