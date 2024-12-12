package com.anuouan;

import cn.hutool.core.date.DateTime;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Title ExistFile
 * @Author: anuouan
 * @Date: 2024/12/12 9:56
 * @Version: v1.0.0
 * @Description: 判断文件是否存在
 **/
@EnableFileStorage
@MapperScan("com.anuouan.mapper")
@SpringBootTest
public class ExistFile {
    @Value("${dromara.x-file-storage.minio[0].end-point}")
    private String endPoint;
    @Autowired
    private FileStorageService fileStorageService;//注入实列

    @Test
    void test1() {
        boolean exists = fileStorageService.exists("http://localhost:9000/demo/20241212/20241212095343.jpg");
        System.out.println("exists = " + exists);
//        boolean delete = fileStorageService.delete("http://localhost:9000/demo/20241212/20241212095343.jpg");
//        System.out.println("delete = " + delete);
//获取文件信息
//        FileInfo fileInfo = fileStorageService.getFileInfoByUrl("http://localhost:9000/demo/20241212/20241212095343.jpg");
//        System.out.println("fileInfo = " + fileInfo);
////判断文件是否存在
//        boolean exists = fileStorageService.exists(fileInfo);
//        System.out.println("exists = " + exists);
////直接通过文件信息中的 url 判断文件是否存在，省去手动查询文件信息记录的过程
//        boolean exists2 = fileStorageService.exists("http://localhost:9000/demo/20241212/20241212095343.jpg");
//        System.out.println("exists2 = " + exists2);

    }

}
