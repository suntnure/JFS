package com.wipro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wipro.DAO.AdminDao;
import com.wipro.model.Admin;

@SpringBootApplication
public class TestdbApplication {
	/* @Autowired
	    private AdminDao admindao;

	    @PostConstruct
	    public void initUsers() {
	        List<Admin> users = Stream.of(
	                new Admin(101,"nikita","nikita","nikita","nikkisunt@gmail.com")
	           //     new Admin(102, "pwd1","user1", "pwd1", "user1@gmail.com")
	               
	        ).collect(Collectors.toList());
	        admindao.saveAll(users);
	    }*/
@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*").allowCredentials(true);
			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(TestdbApplication.class, args);
	}

}
