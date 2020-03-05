
package com.peilw.child.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
/*
@MapperScan(value = "com.peilw.child", sqlSessionFactoryRef = "sqlSessionFactoryBeanl")
*/
public class MyBatisConfigOne {
    //@Autowired
    //@Qualifier("dsOne")
    DataSource dsOne;

    /*@Bean
    SqlSessionFactory sqlSessionFactoryBeanl() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsOne);
        return factoryBean.getObject();
    }*/
       /* @Bean
        SqlSessionTemplate sqlSessionTemplatel () throws Exception {
            return new SqlSessionTemplate(sqlSessionFactoryBeanl());

        }*/
    }
