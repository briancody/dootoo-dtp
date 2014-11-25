package com.roscode.dootoo.dtp.security.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DootooUserDetailsService userDetailsService;
	
	@Autowired private DootooEntryPoint entryPoint;
	@Autowired private DootooFailureHandler failureHandler;
	@Autowired private DootooSuccessHandler successHandler;
	
//	@Bean
//	public AuthenticationManager AuthenticationManager() throws Exception {
//		return new AuthenticationManagerBuilder(new NopPostProcessor())
//			.userDetailsService(userDetailsService).and().build();
//	}
//	
//	private static class NopPostProcessor implements ObjectPostProcessor<Object> {
//		@Override
//		@SuppressWarnings("unchecked")
//		public Object postProcess(Object object) {
//			return object;
//		}
//	}
	
//	@Autowired
//	protected void configureAuthc(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService);
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/happenings/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(entryPoint)
//			.and().formLogin().loginPage("/login").permitAll()
			.and().formLogin().successHandler(successHandler)
			.and().formLogin().failureHandler(failureHandler)
			.and().httpBasic()
			.and().rememberMe()
			.and().userDetailsService(userDetailsService);
//			.and().formLogin();
//			.anonymous();
	}

}
