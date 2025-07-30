package com.pranjal.project.uber.uberApplication.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

	@Bean
	ModelMapper getmodelMapper() {
		return new ModelMapper();
	}

}
