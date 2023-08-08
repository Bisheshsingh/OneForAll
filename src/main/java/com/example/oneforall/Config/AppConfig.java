package com.example.oneforall.Config;

import com.example.oneforall.Services.Addition.Add;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "Addition")
    public Add getAddition() {
        return new Add();
    }
}
