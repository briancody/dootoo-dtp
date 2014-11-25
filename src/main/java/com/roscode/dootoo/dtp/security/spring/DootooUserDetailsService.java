package com.roscode.dootoo.dtp.security.spring;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roscode.dootoo.dtp.user.model.User;
import com.roscode.dootoo.dtp.user.repo.UserRepository;

@Service
public class DootooUserDetailsService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(DootooUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepo;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepo.findById(username);
		} catch (Exception e) {
			log.error("Error during authentication: " + e.getLocalizedMessage());
			throw new UsernameNotFoundException("Could not authenticate");
		}
		if (user == null) {
			throw new UsernameNotFoundException("Could not authenticate");
		}
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), getGrantedAuthorities(username));
	}
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}
}
