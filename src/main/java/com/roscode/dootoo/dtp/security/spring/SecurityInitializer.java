package com.roscode.dootoo.dtp.security.spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends
		AbstractSecurityWebApplicationInitializer {
	
	public SecurityInitializer() {
		super(SecurityConfiguration.class);
	}

}
