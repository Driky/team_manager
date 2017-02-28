package com.gmail.driktheviking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableConfigurationProperties
public class TeamManagerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TeamManagerApplication.class, args);
		new SpringApplicationBuilder(TeamManagerApplication.class).run(args);
	}
}
