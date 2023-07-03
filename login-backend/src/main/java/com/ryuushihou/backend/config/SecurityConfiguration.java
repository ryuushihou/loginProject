package com.ryuushihou.backend.config;

import com.alibaba.fastjson.JSONObject;
import com.ryuushihou.backend.entity.RestBean;
import com.ryuushihou.backend.service.AuthorizeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public AuthorizeService authorizeService;

    public SecurityConfiguration(AuthorizeService authorizeService) {
        this.authorizeService = authorizeService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/auth/login")
                .successHandler(this::onAuthenticationSuccess) // 登陆成功
                .failureHandler(this::onAuthenticationFailure)
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessHandler(this::onAuthenticationSuccess)
                .and()
                .csrf()
                .disable()
                .cors()
                .configurationSource(this.corsConfigurationSource())
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(this::onAuthenticationFailure)
                .and()
                .build();
    }

    private CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addExposedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;
    }

    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException {
        httpServletResponse.setCharacterEncoding("utf-8");
        // json
        if(httpServletRequest.getRequestURI().endsWith("/login")){
            httpServletResponse.getWriter().write(JSONObject.toJSONString(RestBean.success("登陆成功了")));
        }else if(httpServletRequest.getRequestURI().endsWith("/logout")){
            httpServletResponse.getWriter().write(JSONObject.toJSONString(RestBean.success("退出成功！")));
        }

    }

    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException {
        response.setCharacterEncoding("utf-8");
        // json
        response.getWriter().write(JSONObject.toJSONString(RestBean.failure(exception.getMessage())));
    }

    // 校验入力的信息
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity security) throws Exception{
        return security.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(authorizeService)
                .and()
                .build();
    }

    //  encode pw
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
