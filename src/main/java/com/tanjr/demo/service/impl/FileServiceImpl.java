package com.tanjr.demo.service.impl;

import com.tanjr.demo.common.EnumCode;
import com.tanjr.demo.common.ResponseData;
import com.tanjr.demo.service.FileService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    public static final String SAVE_PATH = "D://files";


    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public ResponseData<?> mergeSlice(List<String> fileIdList) {
        return null;
    }

    @Override
    public ResponseData<?> upload(MultipartFile file)  {
        if (file.isEmpty()) {
            return ResponseData.error(EnumCode.PARAMETER_ERROR,"file is empty.");
        }


        String uuid = getUuid();
        String fileName = file.getOriginalFilename();
        // 上传文件
        String filePath = SAVE_PATH + File.separator + uuid + File.separator + fileName;
        File dir = new File(filePath);
        boolean isDirExist = dir.exists();
        if (!isDirExist) {
            isDirExist = dir.mkdirs();
        }
        if (!isDirExist) {
            return ResponseData.error(EnumCode.SYSTEM_ERROR,"mkdir fail.");
        }

        try {
            file.transferTo(dir);
        } catch (IOException e) {
            // throw new SystemDefaultException("上传失败,请联系管理员");
        }
        return ResponseData.success("");
    }
}
