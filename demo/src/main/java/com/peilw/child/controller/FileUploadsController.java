package com.peilw.child.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
@RestController
public class FileUploadsController {
    @PostMapping("/uploads")
    public String upload(MultipartFile[] uploadFiles, HttpServletRequest request){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String realPath=request.getSession().getServletContext().getRealPath("/uploadFile");
        String fmt=simpleDateFormat.format(new Date());
        int i=0;
        for( MultipartFile multipartFile:uploadFiles){
            File file=new File(realPath+fmt);
            if(!file.isDirectory()){
                file.mkdirs();
            }
            String oldName=multipartFile.getOriginalFilename();
            String a=multipartFile.getName();
            String newName = UUID.randomUUID ().toString () +oldName.substring (oldName.lastIndexOf (".") , oldName.length());
            try {
                multipartFile.transferTo(new File (file , newName ) ) ;
                //已二进制存到数据库中
                String filePath = request.getScheme() + "://" + request.getServerName() + ":" +
                        request. getServerPort () +"/uploadFile/" + fmt + newName ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传成功!";
    }
}
