package com.example.spingcloudeurekaserverupload.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("photo") MultipartFile photo) throws IOException {
        if (photo != null) {   // 表示现在已经有文件上传了
            System.out.println("【*** UploadRest ***】文件名称：" + photo.getOriginalFilename() + "、文件大小：" + photo.getSize());
        }
        byte[] bytes = photo.getBytes();
        File fileToSave = new File(photo.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }
}