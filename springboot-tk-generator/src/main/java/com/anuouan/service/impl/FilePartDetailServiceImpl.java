package com.anuouan.service.impl;

import com.anuouan.entity.FilePartDetail;
import com.anuouan.mapper.FilePartDetailMapper;
import com.anuouan.service.IFilePartDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件分片信息表，仅在手动分片上传时使用 服务实现类
 * </p>
 *
 * @author anuouan
 * @since 2024-12-11
 */
@Service
public class FilePartDetailServiceImpl extends ServiceImpl<FilePartDetailMapper, FilePartDetail> implements IFilePartDetailService {

}
