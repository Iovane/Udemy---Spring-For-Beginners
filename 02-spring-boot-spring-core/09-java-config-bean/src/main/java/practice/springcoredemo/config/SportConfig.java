package practice.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import practice.springcoredemo.common.Coach;
import practice.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
