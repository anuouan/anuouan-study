package com.anuouan;

import com.anuouan.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.*;
import java.util.List;

@SpringBootTest
@ActiveProfiles("application.yml")
class SpringbootMysqlApplicationTests {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Test
    void getUser() throws ClassNotFoundException, SQLException {
        // 注册 JDBC 驱动
        Class.forName(driverClassName);

        // 打开链接
        Connection conn = DriverManager.getConnection(url, username, password);

        // 执行查询
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM user";
        ResultSet rs = stmt.executeQuery(sql);

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            User user = new User(rs.getString("username"), rs.getString("password"));
            // 输出数据
            System.out.println("user = " + user);
            System.out.print("\n");
        }
        // 完成后关闭
        rs.close();
        stmt.close();
        conn.close();


    }

}
