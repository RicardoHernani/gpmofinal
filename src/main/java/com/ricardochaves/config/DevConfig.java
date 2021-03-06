package com.ricardochaves.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ricardochaves.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${gpmofinal.spring.jpa.hibernate.ddl-auto}")   			
	private String strategy1;				   
											  
	@Value("${gpmofinal.spring.sql.init.mode}")
	private String strategy2;
		
	@Bean
	public boolean instantiateDatabase() {
		
		if(!"create".equals(strategy1) && !"always".equals(strategy2)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}
	
}
