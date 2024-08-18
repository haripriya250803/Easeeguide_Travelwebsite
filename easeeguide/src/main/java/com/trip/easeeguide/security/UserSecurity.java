package com.trip.easeeguide.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class UserSecurity {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin=User.withUsername("haripriya")
				.password(encoder.encode("admin"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(admin);
		
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
		return http.csrf(csrf -> csrf.disable())
		        .authorizeHttpRequests(auth -> auth
					//.requestMatchers("/travel.css","/project","/path","/get","/bidar.jpeg","charminar.jpeg","logo.jpg","logo2(2).png","logo2.jpg","paris.jpeg","swarnagiri.jpeg","tokyo.jpeg","855633-hd_1920_1080_25fps.mp4")
		            .requestMatchers("/images/**","/css/**","/js/**","/project","/path","/get")
					.permitAll()
		            .anyRequest()
		            .authenticated()
		        )
		        .formLogin(form -> form
		    			
		    			.permitAll()
		    			
		    		)
		        .logout((logout) -> logout
		                .logoutSuccessUrl("/")
		                .permitAll()
		            )
		        
		        .build();
	}

	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
