package com.tathagat.employeeConfiguration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration //tell dispatcher servlet to create Bean
public class EmployeeConfig {
	
	
	
	@Value("${addressservice.base.url}")//getting uri from application.properties.
	private String addressBaseURL;
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	/**@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	*/
	
	@Bean
	public WebClient webclient()
	{
		return WebClient
				.builder()
				.baseUrl(addressBaseURL)
				.build();
	}

}
