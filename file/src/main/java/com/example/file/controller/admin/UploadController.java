package com.example.file.controller.admin;

import com.example.server.dto.ResponseDto;
import com.example.server.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class UploadController {

    // log for logging
    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);
    public static final String BUSINESS_NAME = "文件上传";

    @Value("${file.path}")
    private String FILE_PATH;

    @PostMapping("/upload")
    public ResponseDto list(@RequestParam MultipartFile file) throws IOException {
        LOG.info("上传文件开始");
        String filename = file.getOriginalFilename();
        LOG.info(filename);
        LOG.info(String.valueOf(file.getSize()));

        // 保存文件到本地
        String key = UuidUtil.getShortUuid();
        String fullPath = FILE_PATH + key + "-" + filename;
        File dest = new File(fullPath);
        file.transferTo(dest);
        LOG.info("传输结果文件的绝对路径: " + dest.getAbsolutePath());

        ResponseDto<Object> responseDto = new ResponseDto<>();
        return responseDto;
    }

    @PostMapping("/test")
    public ResponseDto test() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("hi");
        return responseDto;
    }


}
