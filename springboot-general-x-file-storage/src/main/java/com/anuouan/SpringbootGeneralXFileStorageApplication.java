package com.anuouan;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFileStorage
@MapperScan("com.anuouan.mapper")
public class SpringbootGeneralXFileStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGeneralXFileStorageApplication.class, args);
    }

}
