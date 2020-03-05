package com.peilw.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.Resource;
;

@Configuration
@ComponentScan("com.peilw.el")
@PropertySource("classpath:com/peilw/el/test.properties")
public class ElConfig {
@Value("I love you")
    private String normal;
@Value("#{SystemProperties['os.name']}")
    private String osName;
@Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;
@Value("#{demoService.author}")
    private  String formAnothor;
@Value("classpath:com/peilw/el/test.txt")
    private Resource testFile;
@Value("${book.name}")
    private String bookName;
@Autowired
    private Environment environment;
@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
       return  new PropertySourcesPlaceholderConfigurer();
}
public  void outputResource(){
    System.out.println(normal);
    System.out.println(osName);
    System.out.println(randomNumber);
    System.out.println(formAnothor);
    try {
        System.out.println(IOUtils.toString(testFile.getInputStream()));
    }catch (Exception e){
        e.printStackTrace();
    }
    System.out.println(bookName);
    System.out.println(environment.getProperty("book.author"));

}
}
