package com.padawans.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FrameworkPadawansApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkPadawansApplication.class, args);
	}

}
