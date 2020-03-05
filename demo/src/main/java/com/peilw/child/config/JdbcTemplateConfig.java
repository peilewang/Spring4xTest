
package com.peilw.child.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
@Configuration
public class JdbcTemplateConfig {

   /* @Bean
    JdbcTemplate jdbcTemplateOne((@Qualifier("dsOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dsTw")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }*/

}
