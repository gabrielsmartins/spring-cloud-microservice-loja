package br.com.alura.microservices.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class AuthencationInteceptorConfigurer {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new AuthencationInteceptor();
	}
}
