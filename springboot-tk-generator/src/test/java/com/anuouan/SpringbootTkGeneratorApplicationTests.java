package com.anuouan;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.nio.file.Paths;
import java.sql.Types;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//这里指向我们启动类的class
@ActiveProfiles("application.yml")
@SpringBootTest(classes = SpringbootTkGeneratorApplication.class)
public class SpringbootTkGeneratorApplicationTests {


    /**
     * 数据库的配置 jdbc:mysql://127.0.0.1:3306/web_api?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&allowMultiQueries=true
     */
    @Value("${spring.datasource.url}")
    private String sqlUrl;

    /**
     * 数据库用户名
     */
    @Value("${spring.datasource.username}")
    private String username;

    /**
     * 数据库密码
     */
    @Value("${spring.datasource.password}")
    private String password;

    /**
     * 代码生成
     */
    @Test
    public void codeGeneration() throws Exception{
        // 使用 FastAutoGenerator 快速配置代码生成器
        FastAutoGenerator.create(sqlUrl, username, password).globalConfig(builder -> builder
                .author("anuouan")
                .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                .commentDate("yyyy-MM-dd")
        )
                .packageConfig(builder -> builder
                        .parent("com.anuouan")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )

                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }



}