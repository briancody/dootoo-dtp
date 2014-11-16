package com.roscode.dootoo.dtp.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.roscode.dootoo.dtp.user.model.User;
import com.roscode.dootoo.dtp.user.repo.UserRepository;

public class MongoSecurityRealm extends AuthorizingRealm {
	
	@Autowired
	private UserRepository userRepo;
	
	private static final Logger log = LoggerFactory.getLogger(MongoSecurityRealm.class);
	private static final String userRole = "user";
	private static final String userPermission = "readwrite";
	
	public MongoSecurityRealm () {
		// default constructor
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Set<String> roles = new HashSet<String>();
		Set<Permission> permissions = new HashSet<Permission>();

		Collection<User> principalList = principals.byType(User.class);
		for (User user : principalList) {
			log.info("Getting authorization for user " + user.getId());
			roles.add(userRole);
			permissions.add(new WildcardPermission(userPermission));
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setObjectPermissions(permissions);
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authToken = (UsernamePasswordToken) token;
		User user = userRepo.findById(authToken.getUsername());
		if (user != null && user.getPassword().equals(new String(authToken.getPassword()))) {
			return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		} else {
			throw new AuthenticationException("Invalid username/password combination.");
		}
	}

}
