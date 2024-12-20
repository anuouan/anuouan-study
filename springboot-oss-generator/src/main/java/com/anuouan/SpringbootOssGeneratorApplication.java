package com.anuouan;

import com.anuouan.core.FileTemplate;
import com.anuouan.oss.service.OssTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.anuouan"})
@SpringBootApplication
public class SpringbootOssGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootOssGeneratorApplication.class, args);

    }

}
