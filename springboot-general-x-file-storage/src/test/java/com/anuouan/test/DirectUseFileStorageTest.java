package com.anuouan.test;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageProperties;
import org.dromara.x.file.storage.core.FileStorageProperties.FtpConfig;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.FileStorageServiceBuilder;
import org.junit.jupiter.api.Test;

public class DirectUseFileStorageTest {
    @Test
    public void upload() {

        // 配置文件定义存储平台
        FileStorageProperties properties = new FileStorageProperties();
        properties.setDefaultPlatform("ftp-1");
        FtpConfig ftp = new FtpConfig();
        ftp.setPlatform("ftp-1");
        ftp.setHost("192.168.3.100");
        ftp.setPort(2121);
        ftp.setUser("root");
        ftp.setPassword("123456");
        ftp.setDomain("ftp://192.168.3.100:2121/");
        ftp.setBasePath("ftp/");
        ftp.setStoragePath("/");
        properties.setFtp(Collections.singletonList(ftp));

        // 创建，自定义存储平台、Client工厂、切面等功能都有对应的添加方法
        FileStorageService service =
                FileStorageServiceBuilder.create(properties).useDefault().build();

        // 初始化完毕，开始上传吧
        FileInfo fileInfo = service.of(new File("D:\\Desktop\\a.png")).upload();
        System.out.println(fileInfo);

        String filename = "image.jpg";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
        FileInfo fileInfo2 = service.of(in).setOriginalFilename(filename).upload();
        System.out.println(fileInfo2);
    }
}
