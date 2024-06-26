package com.testbeackenddeveloper.fikrizulfikarkusmana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableConfigurationProperties
@SpringBootApplication
public class FikrizulfikarkusmanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FikrizulfikarkusmanaApplication.class, args);
	}

}
