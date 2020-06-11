package com.techmahindra.associateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceAssociateServiceApplication {

	@Bean
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAssociateServiceApplication.class, args);
	}

}
