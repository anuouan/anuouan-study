package com.anuouan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.anuouan.mapper")
@SpringBootApplication
public class SpringbootMyBatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMyBatisPlusApplication.class, args);
    }

}
