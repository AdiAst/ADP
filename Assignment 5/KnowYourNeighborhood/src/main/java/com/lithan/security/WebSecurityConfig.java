package com.lithan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	  public static PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    // Authorize
	    http.authorizeRequests()	    	
	        .antMatchers("/").authenticated()
	        .antMatchers("/stores").hasRole("[VIEW_STORE]")
	        .antMatchers("/admin").authenticated()
	        .antMatchers("/addStore/**").hasRole("[ADD_STORE]")
	        .antMatchers("/editStore/**").hasRole("[ADD_STORE]")
	        .antMatchers("/deleteStore").hasRole("ADD_STORE");

	    // Form Login
	    http.formLogin()
	        .loginPage("/login")
	        .loginProcessingUrl("/loginProcess")
	        .permitAll();
	    
	
	    // Logout
	    http.logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .permitAll();

	    return http.build();
	  }
}
