package com.anuouan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文件分片信息表，仅在手动分片上传时使用
 * </p>
 *
 * @author anuouan
 * @since 2024-12-11
 */
@Getter
@Setter
@TableName("file_part_detail")
public class FilePartDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分片id
     */
    private String id;

    /**
     * 存储平台
     */
    private String platform;

    /**
     * 上传ID，仅在手动分片上传时使用
     */
    private String uploadId;

    /**
     * 分片 ETag
     */
    private String eTag;

    /**
     * 分片号。每一个上传的分片都有一个分片号，一般情况下取值范围是1~10000
     */
    private Integer partNumber;

    /**
     * 文件大小，单位字节
     */
    private Long partSize;

    /**
     * 哈希信息
     */
    private String hashInfo;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
