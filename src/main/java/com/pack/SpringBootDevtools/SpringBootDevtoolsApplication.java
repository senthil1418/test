package com.pack.SpringBootDevtools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevtoolsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootDevtoolsApplication.class, args);
		SpringApplication application =new SpringApplication(SpringBootDevtoolsApplication.class);
		Map<String, Object> map = new HashMap<>();
        map.put("SERVER_PORT", "8585");
        application.setDefaultProperties(map);
        application.run(args);
	}

}
