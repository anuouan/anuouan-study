package com.anuouan;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.anuouan.mapper")
@EnableFileStorage
//支持 File、MultipartFile、UploadedFile、byte[]、InputStream、URL、URI、String、HttpServletRequest，大文件会自动分片上传。
@SpringBootApplication
public class SpringbootXFileStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootXFileStorageApplication.class, args);
    }

}
