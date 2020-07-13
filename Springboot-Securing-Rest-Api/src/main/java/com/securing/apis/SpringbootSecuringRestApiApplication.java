package com.securing.apis;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class SpringbootSecuringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecuringRestApiApplication.class, args);
	}

	/*
	@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder()
				.username("carol")
				.password("carol")
				.roles("USER").build()
		);
	}  
	
	@Bean
	UserDetailsService userDetailsService(DataSource datasource) {
		@Override
		protected List<GrantedAuthority> loadUserAuthorities(String username){
			return (UserDetailsService) AuthorityUtils.createAuthorityList("ROLE_USER");
		};
		return new JdbcUserDetailsManager(datasource);
	}*/

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
