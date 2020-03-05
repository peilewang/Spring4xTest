package com.peilw.child.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.catalina.startup.ContextConfig;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public Realm realm(){
        TextConfigurationRealm textConfigurationRealm=new TextConfigurationRealm();
        textConfigurationRealm.setUserDefinitions("sang=123,user\n admin=123,admin");
        textConfigurationRealm.setRoleDefinitions("admin=read,write\n user=read");
        return textConfigurationRealm;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition=new DefaultShiroFilterChainDefinition();
        defaultShiroFilterChainDefinition.addPathDefinition("/login","anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/doLogin","anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/logout","logout");
        defaultShiroFilterChainDefinition.addPathDefinition("/**","authc");
        return defaultShiroFilterChainDefinition;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
