package start.myprojectbe.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import start.myprojectbe.model.Roles;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		// Authentication manager
		auth.inMemoryAuthentication()
				.withUser("user1").password(passwordEncoder().encode("user1")).roles(Roles.USER_ROLE)
				.and()
				.withUser("user2").password(passwordEncoder().encode("user2")).roles(Roles.USER_ROLE)
				.and()
				.withUser("admin").password(passwordEncoder().encode("admin")).roles(Roles.ADMIN_ROLE);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/swagger-ui/**", "/javainuse-openapi/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

