package com.comunication.fasto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FastoApplication {
	/*MapReactiveUserDetailsService users() {
   	return new MapReactiveUserDetailsService(User.withDefaultPasswordEncoder().username("user").password("pw").roles("USER").build());
   }*/
	public static void main(String[] args) {
		SpringApplication.run(FastoApplication.class, args);
	}
	/*@Configuration
	@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					.antMatchers("/register").permitAll()
					.antMatchers("/login").permitAll();
		}
	}*/
}
