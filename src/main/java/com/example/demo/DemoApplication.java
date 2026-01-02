package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "com.example.demo",
        //includeFilters = @ComponentScan.Filter(
        //        type = FilterType.REGEX,
        //        pattern = "com.example.demo.entities\\.*"

        excludeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
               pattern = "com.example.demo.testingEntities*"
        )
)

@EntityScan("com.example.demo.chinookEntities")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
	}
}
