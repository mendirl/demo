package com.example.demo;

import org.springframework.boot.SpringApplication;


public class TestDemoApplication {
	public static void main(String[] args) {
		SpringApplication.from(DemoApplication::main).with(MyContainersConfiguration.class).run(args);
	}
}
