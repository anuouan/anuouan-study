package com.anuouan;

import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@EnableFileStorage
@SpringBootTest
class Upload_HttpServletRequest {

    @Autowired
    private FileStorageService fileStorageService;//注入实列

    FileInputStream fileInputStream = new FileInputStream("D:\\anuouan\\anuouanStudio\\anuouan-study\\springboot-x-file-storage\\src\\main\\resources\\static\\1.jpg");
    MultipartFile file = new MockMultipartFile("file", "1.jpg", "image/jpeg", fileInputStream);

    Upload_HttpServletRequest() throws IOException {
    }


    /**
     * @Author anuouan
     * @Param null
     * @Return void
     * @Date 2024/12/10 18:07
     * @Description
     * 直接上传 HttpServletRequest
     * 这种方式通过直接读取输入流进行上传，可以实现文件不落盘，边读取边上传，速度更快
     *
     * 需要先在配置文件中开启 multipart 懒加载，不然在 Controller 中拿到输入流是已经被读取过的
     *
     * spring.servlet.multipart.resolve-lazily: true
     */

    @Test
    void test1() throws IOException {

    }
}
