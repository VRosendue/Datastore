package com.postgres.inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Injector {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.url}")
	private String username;
	@Value("${spring.datasource.url}")
	private String password;

}