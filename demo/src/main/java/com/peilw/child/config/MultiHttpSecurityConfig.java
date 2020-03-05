package com.peilw.child.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true )
public class MultiHttpSecurityConfig {
   /* @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }*/
    @Autowired
    protected void  configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
             authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("123")
                     .roles("ADMIN","USER").and();
    }

}
