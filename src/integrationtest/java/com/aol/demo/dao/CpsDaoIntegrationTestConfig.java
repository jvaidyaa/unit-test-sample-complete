package com.aol.demo.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.aol.demo.RestConfiguration;

@Configuration
@ImportResource({"classpath*:spring/properties-context.xml"}) 
@Import(value={RestConfiguration.class})
@Profile("integrationtesting")
public class CpsDaoIntegrationTestConfig {
	@Bean
	public CpsDao cpsDao() {
		return new CpsDaoImpl();
	}
}