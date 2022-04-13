package com.example.spring.services;

import com.example.spring.services.security.JWTAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class JavaSpringServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringServicesApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					//.antMatchers(HttpMethod.POST, "/api").permitAll()
					//.antMatchers(HttpMethod.GET, "/api").permitAll()
					.antMatchers(HttpMethod.POST, "/api/auth").permitAll()
					.anyRequest().authenticated();
		}
	}
}
