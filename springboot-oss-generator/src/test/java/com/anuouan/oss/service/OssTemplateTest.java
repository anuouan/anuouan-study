package com.anuouan.oss.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.StrBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.anuouan.bean.User;
import com.anuouan.core.FileProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Title OssTemplateTest
 * @Author: anuouan
 * @Date: 2024/12/20 11:28
 * @Version: v1.0.0
 * @Description: TODO
 **/
@SpringBootApplication(scanBasePackages = "com.anuouan")

@SpringBootTest
class OssTemplateTest {
    @Autowired
    OssTemplate ossTemplate;

    @Test
    void s3_getBucketAcl() {
//        AmazonS3 amazonS3 = ossTemplate.getAmazonS3();

        System.out.println("ossTemplate = " + ossTemplate);
//        AccessControlList acl = amazonS3.getBucketAcl("test");
//        System.out.println("acl = " + acl);
    }
    @Test
    void upload() {
        File file = FileUtil.mkdir(System.getProperty("user.dir") + "/test");
        boolean exists = file.exists();
        System.out.println("exists = " + exists);
        boolean mkdir = file.mkdir();
        System.out.println("mkdir = " + mkdir);
        System.out.println(file!=null);

    }
    @Test
    void createBucket() {
        System.out.println("ossTemplate = " + ossTemplate);
        ossTemplate.createBucket("my-test");
    }

    @Test
    void getAllBuckets() {
        System.out.println("ossTemplate = " + ossTemplate);
        List<Bucket> allBuckets = ossTemplate.getAllBuckets();
        allBuckets.forEach(System.out::println);
//        ossTemplate.getAllBuckets().forEach(System.out::println);
    }

    @Test
    void getBucket() {
        Optional<Bucket> test = ossTemplate.getBucket("test");
        System.out.println("test = " + test);
    }

    @Test
    void removeBucket() {
        ossTemplate.removeBucket("my-test");
    }

    @Test
    void getAllObjectsByPrefix() {
        List<S3ObjectSummary> allObjectsByPrefix = ossTemplate.getAllObjectsByPrefix("demo", "20241211/2024", true);
        allObjectsByPrefix.forEach(System.out::println);
    }

    @Test
    void getObjectURL() {
        String url = ossTemplate.getTemporaryObjectURL("demo", "20241211/20241211135035.png", 1);
        System.out.println("url = " + url);
    }

    @Test
    void getObject() {
        S3Object s3Object = ossTemplate.getObject("demo", "20241211/20241211135035.png");
        System.out.println("s3Object = " + s3Object);
        //s3Object = S3Object [key=20241211/20241211135035.png,bucket=demo]
    }

    @Test
    void putObject() throws Exception {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("1.jpg");
        ossTemplate.putObject("test", "test1.jpg", in);

    }

    @Test
    void testPutObject_object() throws Exception {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setAddress("北京");
        //将对象转换为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println("jsonString = " + jsonString);
        //将json字符串转换为对象
        User userObject = objectMapper.readValue(jsonString, User.class);
        System.out.println("userObject = " + userObject);


        //转换为流
        byte[] inputStream = objectMapper.writeValueAsBytes(user);
        InputStream is = new ByteArrayInputStream(inputStream);
        System.out.println("is = " + is);
//        User user1 = objectMapper.readValue(is, User.class);
        ossTemplate.putObject("test", "user", is);


//        System.out.println("user1 = " + user1);
    }

    @Test
    void testGetStreamToUser() throws Exception {
        String obj = ossTemplate.getTemporaryObjectURL("test", "user", 7);
        System.out.println("obj = " + obj);
//        URL url = new URL(obj);
//        obj = http://127.0.0.1:9000/test/user?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20241220T070801Z&X-Amz-SignedHeaders=host&X-Amz-Expires=604799&X-Amz-Credential=aCUjNqdJfFdgi20ZHkKH%2F20241220%2Ftest_region%2Fs3%2Faws4_request&X-Amz-Signature=771e9e43416f9349fce82f4c61341fbd3618b6f10190f75089e350d2e81a84e1
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(new URL(obj), User.class);
        System.out.println("user = " + user);
//        user = User(name=张三, age=18, address=北京)

    }

    @Test
    void testPutObject1() {
        String s = "http://127.0.0.1:9000/demo/20241211/20241211135035.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20241220T071631Z&X-Amz-SignedHeaders=host&X-Amz-Expires=86399&X-Amz-Credential=aCUjNqdJfFdgi20ZHkKH%2F20241220%2Ftest_region%2Fs3%2Faws4_request&X-Amz-Signature=7763943c7047332180d05de925b8786ef97ee25b4503c0d5bd4f44507fd4b481";
        System.out.println(s);
//        String[] split = s.split("/");
//        System.out.println(Arrays.toString(split));
        System.out.println(s.indexOf("/",1));
        System.out.println(s.substring(0,s.indexOf("/",0)));
        System.out.println(s.substring(s.indexOf("/",3),s.indexOf("?")));
//        System.out.println(s.substring(0,s.indexOf("/",0)));
//        System.out.println(s.substring(0,s.indexOf("/",0)));
//        System.out.println(s.indexOf("/",3));

    }

    @Test
    void getObjectInfo() throws Exception {
        S3Object info = ossTemplate.getObjectInfo("test", "test1.jpg");
        System.out.println("info = " + info);
    }

    @Test
    void removeObject() throws Exception {
        ossTemplate.removeObject("test", "test1");
    }
}