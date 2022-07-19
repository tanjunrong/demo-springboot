package com.tanjr.demo.service;

import com.tanjr.demo.common.ResponseData;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    ResponseData<?> mergeSlice(List<String> fileIdList);

    ResponseData<?> upload(MultipartFile file);
}
