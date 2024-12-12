package com.anuouan;

import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageProperties;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.FileStorageServiceBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;

public class DirectUseFileStorageTest {
    @Test
    public void upload() {

        // 配置文件定义存储平台

        FileStorageProperties properties = new FileStorageProperties();

        properties.setDefaultPlatform("minio-1");
        FileStorageProperties.MinioConfig minio = new FileStorageProperties.MinioConfig();
        minio.setPlatform("minio-1");
        minio.setAccessKey("aCUjNqdJfFdgi20ZHkKH");
        minio.setSecretKey("quFIlrQKjMJ0LiTAN5JACwsfmWy8gCZHfiMEaQqH");
        minio.setEndPoint("http://localhost:9000");
        minio.setBucketName("demo");

        properties.setMinio(Collections.singletonList(minio));

        // 创建，自定义存储平台、Client工厂、切面等功能都有对应的添加方法
        FileStorageService service =
                FileStorageServiceBuilder.create(properties).useDefault().build();

        // 初始化完毕，开始上传吧
        FileInfo fileInfo = service.of(new File("D:\\anuouan\\anuouanStudio\\anuouan-study\\springboot-general-x-file-storage\\src\\test\\resources\\image.jpg")).upload();
        System.out.println(fileInfo);

        String filename = "image2.jpg";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
        FileInfo fileInfo2 = service.of(in).setOriginalFilename(filename).upload();
        System.out.println(fileInfo2);
    }
}
