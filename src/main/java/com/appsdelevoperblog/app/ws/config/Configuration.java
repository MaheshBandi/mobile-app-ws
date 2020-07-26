package com.appsdelevoperblog.app.ws.config;


import com.appsdelevoperblog.app.ws.SpringApplicationContext;
import com.appsdelevoperblog.app.ws.security.AppProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SpringApplicationContext springApplicationContext(){
        return new SpringApplicationContext();
    }
    @Bean(name = "AppProperties")
    public AppProperties getAppProperties(){
        return new AppProperties();
    }

}
