package com.anuouan;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.constant.Constant;
import org.dromara.x.file.storage.core.get.ListFilesResult;
import org.dromara.x.file.storage.core.get.ListFilesSupportInfo;
import org.dromara.x.file.storage.core.get.RemoteFileInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@Slf4j
@SpringBootTest
class FileStorageServiceGetTest {

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * 测试列举文件
     */
    @Test
    public void listFiles() {
        ListFilesSupportInfo isSupportListFiles = fileStorageService.isSupportListFiles();
        if (!isSupportListFiles.getIsSupport()) {
            log.info("暂不支持列举文件");
            return;
        }

        ListFilesResult result = fileStorageService.listFiles().setPath("test/").listFiles();

        result.getDirList().forEach(info -> log.info("目录：{}", info));
        log.info("列举目录完成，共 {} 个目录", result.getDirList().size());
        result.getFileList().forEach(info -> log.info("文件：{}", info));
        log.info("列举文件完成，共 {} 个文件", result.getFileList().size());
        log.info("列举文件全部结果：{}", result);
    }

    public FileInfo upload() {
        String filename = "image.jpg";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
        FileInfo fileInfo = fileStorageService
                .of(in)
                .setName("file")
                .setOriginalFilename(filename)
                .setPath("test/")
                .setNotSupportAclThrowException(false)
                .setFileAcl(Constant.ACL.PUBLIC_READ)
                .setNotSupportMetadataThrowException(false)
                .putMetadata(Constant.Metadata.CONTENT_DISPOSITION, "attachment;filename=DownloadFileName.jpg")
                .putMetadata("Test-Not-Support", "123456") // 测试不支持的元数据
                .putUserMetadata("role", "666")
                .upload();
        Assert.notNull(fileInfo, "文件上传失败！");
        log.info("文件上传成功：{}", fileInfo.toString());
        return fileInfo;
    }

    /**
     * 测试获取文件
     */
    @Test
    public void getFile() {
        FileInfo fileInfo = upload();

        RemoteFileInfo info = fileStorageService
                .getFile()
                .setPath(fileInfo.getPath())
                .setFilename(fileInfo.getFilename())
                .setUrl(fileInfo.getUrl())
                .getFile();
        Assert.notNull(info, "获取文件失败！");
        log.info("获取文件结果：{}", info);

        FileInfo fileInfo2 = info.toFileInfo();
        log.info("文件结果转成 FileInfo：{}", fileInfo2);

        fileStorageService.delete(fileInfo);

        RemoteFileInfo info2 = fileStorageService
                .getFile()
                .setPath(fileInfo.getPath())
                .setFilename(fileInfo.getFilename())
                .getFile();
        Assert.isNull(info2, "获取不存在的文件失败！");
        log.info("获取不存在的文件结果：{}", info2);
    }
}
