package edu.cibertec.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.cibertec.filter.LoginFilter;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.cibertec"})
@EntityScan(basePackages = {"edu.cibertec.entity"})
@EnableJpaRepositories(basePackages = {"edu.cibertec.repository"})
@EnableTransactionManagement
public class AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	@Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns(
                "/principal",
                "/usuario/*",
                "/curso/*",
                "/matricula/*"
        );
        registration.setOrder(1);
        return registration;
    }

}
