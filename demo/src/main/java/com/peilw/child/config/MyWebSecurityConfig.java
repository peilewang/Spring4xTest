package com.peilw.child.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peilw.child.components.CustomAccessDecisionManager;
import com.peilw.child.components.CustomFilterInvocationSecurityMetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.security.auth.login.CredentialException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("123").roles("ADMIN", "USER")
                .and()
                .withUser("sang").password("123").roles("USER");
    }

    @Bean
    CustomFilterInvocationSecurityMetadataSource cfisms() {
        return new CustomFilterInvocationSecurityMetadataSource();
    }

    @Bean
    CustomAccessDecisionManager cadm() {
        return new CustomAccessDecisionManager();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().withObjectPostProcessor(new
                                                                         ObjectPostProcessor<FilterSecurityInterceptor>() {
                                                                             public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                                                                                 object.setSecurityMetadataSource(cfisms());
                                                                                 object.setAccessDecisionManager(cadm());
                                                                                 return object;
                                                                             }
                                                                         }
        ).antMatchers("/admin/**")
                .hasRole("ADMIN").antMatchers("/USER/**").access("hasAnyRole ( ' ADMIN' , 'USER')").antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasAnyRole('DBA')")/*.anyRequest().authenticated()*/.and().formLogin().loginPage("login_page").loginProcessingUrl("/login")
                .usernameParameter("name").passwordParameter("password").successHandler(
                new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
                        Object principal = authentication.getPrincipal();
                        httpServletResponse.setContentType("application/json;charset=utf- 8");
                        PrintWriter out = httpServletResponse.getWriter();
                        httpServletResponse.setStatus(200);
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("status", 200);
                        map.put("msg", principal);
                        ObjectMapper objectMapper = new ObjectMapper();
                        out.write(objectMapper.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                }
        ).failureHandler(
                new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException {
                        httpServletResponse.setContentType("application/json;charset=utf- 8");
                        httpServletResponse.setStatus(401);
                        PrintWriter out = httpServletResponse.getWriter();
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("status", 401);
                        if (authenticationException instanceof LockedException) {
                            map.put("msg", "登录账户被锁定");
                        } else if (authenticationException instanceof BadCredentialsException) {
                            map.put("msg", "用户名或密码错误");
                        } else if (authenticationException instanceof DisabledException) {
                            map.put("msg", "账户被禁用");
                        } else if (authenticationException instanceof AccountExpiredException) {
                            map.put("msg", "账户已过期");
                        } else if (authenticationException instanceof CredentialsExpiredException) {
                            map.put("msg", "密码已过期");
                        } else {
                            map.put("msg", "登录失败！");
                        }
                        ObjectMapper objectMapper = new ObjectMapper();
                        out.write(objectMapper.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                }
        ).permitAll().and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true)
                .addLogoutHandler(
                        new LogoutHandler() {
                            @Override
                            public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

                            }
                        }
                ).logoutSuccessHandler(
                new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.sendRedirect("/login_page");
                    }
                }
        );
    }
}
