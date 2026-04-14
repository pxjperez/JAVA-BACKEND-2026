package edu.cibertec.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(true)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "edu.cibertec")
public class AppConfig {
    
}
