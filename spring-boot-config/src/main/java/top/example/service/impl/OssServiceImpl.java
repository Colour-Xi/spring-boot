package top.example.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.example.config.OssConfig;
import top.example.service.OssService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Service
public class OssServiceImpl implements OssService {

    @Resource
    private OssConfig ossConfig;
    @Override
    public String upload(MultipartFile file) {
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            //获取后缀名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;
            log.info("上传文件名:{}", fileName);
            //读取配置文件
            String endpoint = ossConfig.getEndpoint();
            String bucketName = ossConfig.getBucket();
            String accessKeyId = ossConfig.getAccessKeyId();
            String accessKeySecret = ossConfig.getAccessKeySecret();
            String dir = ossConfig.getDir();

            //创建OSS客户端
            OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
            String uploadUrl = dir + fileName;
            InputStream inputStream;
            try {
                inputStream = file.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ossClient.putObject(bucketName, uploadUrl, inputStream);
            ossClient.shutdown();
            log.info("上传成功:{}", uploadUrl);
            return "https://"+bucketName+"."+endpoint+"/"+uploadUrl;
        }
        return "上传失败";
    }
}
