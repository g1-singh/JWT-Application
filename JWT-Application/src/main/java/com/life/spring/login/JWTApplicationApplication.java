package com.life.spring.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JWTApplicationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JWTApplicationApplication.class, args);
//	AdminRepository repository = context.getBean(AdminRepository.class);
//	Admin admin=new Admin();
//	admin.setUserName("jeevan");
//	admin.setPassword("12345");
//	admin.setLoggedIn(false);
//	repository.save(admin);
		System.out.println("Application Starting");
		System.out.println("Hey Always Be Happy");
	}

}
