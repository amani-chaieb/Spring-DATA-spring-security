package tn.enig.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		PasswordEncoder crypt=cryptageMP();
		try {
	
		auth.inMemoryAuthentication().withUser("ali").password(crypt.encode("enig")).roles("USER");	
		auth.inMemoryAuthentication().withUser("ahmed").password(crypt.encode("enig")).roles("USER");	
		auth.inMemoryAuthentication().withUser("emna").password(crypt.encode("enig")).roles("ADMIN");	
		auth.inMemoryAuthentication().withUser("aya").password(crypt.encode("enig")).roles("AGENT");
		/*
		.usersByUsernameQuery("select principal, credentials, 1 from user where principal=?" )
		.authoritiesByUsernameQuery("select * from roles where principal=? ")
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, 1  from user1 where username=?" )
		.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_role where user_username=? ")
		.passwordEncoder(crypt)
		.rolePrefix("ROLE_");*/
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/ajout/**").hasAnyRole("ADMIN","AGENT");
		http.authorizeRequests().antMatchers("/delete/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf();
		
	}
	@Bean
	public PasswordEncoder cryptageMP() {
		/*System.out.println(new BCryptPasswordEncoder().encode("enig"));*/
		return new BCryptPasswordEncoder();
	}
}

