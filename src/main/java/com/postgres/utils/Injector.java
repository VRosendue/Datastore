package com.postgres.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Injector {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.url}")
	private String username;
	@Value("${spring.datasource.url}")
	private String password;

}