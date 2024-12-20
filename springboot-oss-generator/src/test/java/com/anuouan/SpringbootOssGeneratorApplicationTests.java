package com.anuouan;

import com.anuouan.core.FileProperties;
import com.anuouan.core.FileTemplate;
import com.anuouan.oss.OssProperties;
import com.anuouan.oss.http.OssEndpoint;
import com.anuouan.oss.service.OssTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.InputStream;
@SpringBootApplication(scanBasePackages = "com.anuouan")
//@ActiveProfiles("application.yml")
@SpringBootTest(classes = SpringbootOssGeneratorApplication.class)
class SpringbootOssGeneratorApplicationTests {

    @Autowired
    OssTemplate ossTemplate;
    @Autowired
    OssEndpoint ossEndpoint;
    @Autowired
    FileTemplate fileTemplate;
    @Test
    void test1() {
//        OssProperties ossProperties = new OssProperties();
//        OssTemplate o = new OssTemplate(new FileProperties());
        System.out.println("-----------------------------");
        System.out.println("ossEndpoint = " + ossEndpoint);
        System.out.println("ossTemplate = " + ossTemplate);
        System.out.println("fileTemplate.toString() = " + fileTemplate.toString());

//        ossTemplate.createBucket("test");


//        ossTemplate.putObject("test", "1.jpg", new File("1.jpg"));


    }
    @Test
    void contextLoads() {

//        System.out.println("ossTemplate = " + ossTemplate);
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("1.jpg");
        System.out.println("in = " + in);
//        ossTemplate.put().putObject("demo", "1.jpg", new File("1.jpg"));
// 上传文件
//        ossTemplate.put().putObject("bucket", "1.jpg", new File("1.jpg"));
    }

}
