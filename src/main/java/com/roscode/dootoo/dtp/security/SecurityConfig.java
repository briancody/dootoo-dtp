package com.roscode.dootoo.dtp.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
		factory.setSecurityManager(securityManager());
		
		return factory;
	}

//	@Bean
//	public MongoSecurityRealm mongoSecurityRealm() {
//		return new MongoSecurityRealm();
//	}
//
	@Bean
	public AuthenticatingRealm mongoSecurityRealm() {
		AuthenticatingRealm realm = new AuthenticatingRealm() {
			
			@Override
			protected AuthenticationInfo doGetAuthenticationInfo(
					AuthenticationToken token) throws AuthenticationException {
				return new SimpleAuthenticationInfo("user", "password", "login");
			}
		};
		realm.setName("login");
		return realm;
	}
	
	@Bean
	public SecurityManager securityManager() {
		return new DefaultWebSecurityManager(mongoSecurityRealm());
	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	
//	@Bean
//	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
//		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
//		methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//		methodInvokingFactoryBean.setArguments(new Object[]{securityManager()});
//		return methodInvokingFactoryBean;
//	}
//	
//	@Bean
//	@DependsOn(value="lifecycleBeanPostProcessor")
//	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//		return new DefaultAdvisorAutoProxyCreator();
//	}
//	
//	@Bean
//	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
//		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
//		return authorizationAttributeSourceAdvisor;
//	}
}
