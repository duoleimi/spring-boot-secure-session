package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全认证配置
 * 
 * @author lll
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties security;

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(
				passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		if (!security.isEnableCsrf()) {
			http.csrf().disable();
		} else {
			http.csrf().ignoringAntMatchers("/login");
		}

		http.authorizeRequests()
				.anyRequest().fullyAuthenticated()
				.and()
					.formLogin().loginPage("/loginp").loginProcessingUrl("/login")
					.successHandler(new AuthSuccessHandler("/succ","/api/token"))
					.failureHandler(new AuthFailHandler("/loginp?error")).permitAll()
				.and()
					.logout()
					.logoutUrl("/logout")
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/loginp").permitAll();
	}

}
