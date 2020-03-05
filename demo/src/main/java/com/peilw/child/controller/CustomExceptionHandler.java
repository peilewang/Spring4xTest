package com.peilw.child.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public  void uploadEexception(MaxUploadSizeExceededException e, HttpServletResponse httpServletResponse) throws IOException {
          httpServletResponse.setContentType("text/html;charset=utf-8");
          PrintWriter printWriter=httpServletResponse.getWriter();
          printWriter.write("文件大小超出限制");
          printWriter.flush();
          printWriter.close();
    }
    /*@ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadEexception1(MaxUploadSizeExceededException e, HttpServletResponse httpServletResponse) throws IOException {
         ModelAndView modelAndView=new ModelAndView();
         modelAndView.addObject("msg","文件大小超过限制");
         modelAndView.setViewName("uploaderror");
         return  modelAndView;
    }*/
}
