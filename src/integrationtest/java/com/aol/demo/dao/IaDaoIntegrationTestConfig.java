package com.aol.demo.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.aol.demo.RestConfiguration;

@Configuration
@ImportResource({"classpath*:spring/properties-context.xml"})
@Profile("integrationtesting")
@Import({RestConfiguration.class})
public class IaDaoIntegrationTestConfig {
	
	@Bean
	public IaDao iaDao() {
		return new IaDaoImpl();
	}
	
}