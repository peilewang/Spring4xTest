package com.peilw.child.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static javafx.scene.input.KeyCode.I;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
        String fmt = simpleDateFormat.format(new Date());
        File file = new File(realPath + fmt);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String a = uploadFile.getName();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            uploadFile.transferTo(new File(file, newName));
            //已二进制存到数据库中
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + fmt + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }
}
