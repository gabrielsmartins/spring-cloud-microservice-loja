package br.com.alura.microservices.loja.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthencationInteceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if(authentication == null)
        	 return;
         
         OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
         String tokenValue = details.getTokenValue();
         template.header("Authorization", "Bearer " + tokenValue);
	}

}
