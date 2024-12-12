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
class Upload_Simple {

    @Autowired
    private FileStorageService fileStorageService;//注入实列

    FileInputStream fileInputStream = new FileInputStream("D:\\anuouan\\anuouanStudio\\anuouan-study\\springboot-x-file-storage\\src\\main\\resources\\static\\1.jpg");
    MultipartFile file = new MockMultipartFile("file", "1.jpg", "image/jpeg", fileInputStream);

    Upload_Simple() throws IOException {
    }

    /**
     * @Author anuouan
     * @Param null
     * @Return void
     * @Date 2024/12/10 17:38
     * @Description 直接上传
     */
    @Test
    void test1() throws IOException {
        // 直接上传
        FileInfo fileInfo = fileStorageService.of(file).upload();
        System.out.println("fileInfo = " + fileInfo);
    }

    /**
     * @Author anuouan
     * @Param null
     * @Return void
     * @Date 2024/12/10 17:39
     * @Description 如果要用 byte[]、InputStream、URL、URI、String 等方式上传，暂时无法获取 originalFilename 属性，最好手动设置
     */
    @Test
    void test2() throws FileNotFoundException {
        System.out.println("file = " + file);
        FileInfo fileInfo = fileStorageService.of(file).setOriginalFilename("setOriginalFilename.jpg").upload();
        System.out.println("fileInfo = " + fileInfo);
    }

    @Test
    void test3() {
        // 上传到指定路径下
        fileStorageService.of(file)
                .setPath("upload/") // 保存到相对路径下，为了方便管理，不需要可以不写
                .upload();
    }

    @Test
    void test4() {
        // 关联文件参数并上传
        fileStorageService.of(file)
                .setObjectId("0")   // 关联对象id，为了方便管理，不需要可以不写
                .setObjectType("0") // 关联对象类型，为了方便管理，不需要可以不写
                .putAttr("role","admin") //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
                .putAttr("username","007")
                .upload();
    }

    @Test
    void test5() {
        // 上传到指定的存储平台
        fileStorageService.of(file)
                .setPlatform("aliyun-oss-1")    // 使用指定的存储平台
                .upload();
    }

    @Test
    void test6() {
        // 对图片进行处理并上传，有多个重载方法。图片处理使用的是 https://github.com/coobird/thumbnailator
        fileStorageService.of(file)
                .setThumbnailSuffix(".jpg") //指定缩略图后缀，必须是 thumbnailator 支持的图片格式，默认使用全局的
                .setSaveThFilename("thabc") //指定缩略图的保存文件名，注意此文件名不含后缀，默认自动生成
                .image(img -> img.size(1000,1000))  // 将图片大小调整到 1000*1000
                .thumbnail(th -> th.size(200,200))  // 再生成一张 200*200 的缩略图
                .upload();
    }

}
