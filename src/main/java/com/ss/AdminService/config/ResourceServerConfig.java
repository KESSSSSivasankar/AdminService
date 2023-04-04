package com.ss.AdminService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

	@Value("${spring.security.oauth2.resourceserver.auth.uri}")
	String issueUri;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(auth-> auth.anyRequest().authenticated())
				.oauth2ResourceServer(oauth2->oauth2.jwt(jwt->jwt.decoder(JwtDecoders.fromIssuerLocation(issueUri)))).build();
		
	}
}