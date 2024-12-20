package com.anuouan.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Title FileTemplateTest
 * @Author: anuouan
 * @Date: 2024/12/20 11:32
 * @Version: v1.0.0
 * @Description: TODO
 **/
@SpringBootApplication(scanBasePackages = "com.anuouan")
@SpringBootTest
class FileTemplateTest {
FileTemplate fileTemplate;
    @Test
    void createBucket() {
        fileTemplate.createBucket("tset_fileTemplate");
    }

    @Test
    void getAllBuckets() {
    }

    @Test
    void removeBucket() {
    }

    @Test
    void putObject() {
    }

    @Test
    void testPutObject() {
    }

    @Test
    void getObject() {
    }

    @Test
    void removeObject() {
    }

    @Test
    void afterPropertiesSet() {
    }

    @Test
    void getAllObjectsByPrefix() {
    }
}