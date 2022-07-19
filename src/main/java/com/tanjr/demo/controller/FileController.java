package com.tanjr.demo.controller;

import com.tanjr.demo.common.ResponseData;
import com.tanjr.demo.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author t30010543
 */
@Api("文件管理")
@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public ResponseData<?> upload(@RequestPart(value="file") MultipartFile file) {
        return fileService.upload(file);
    }

    @PostMapping("/merge-slice")
    @ApiOperation("文件合并")
    public ResponseData<?> mergeSlice(@RequestBody @Validated List<String> fileIdList) {
        return fileService.mergeSlice(fileIdList);
    }
}
