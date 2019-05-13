package com.talk2amareswaran.projects.springboot2authserver.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String input) {
		/*User user = userRepository.findByUsername(input);

		if (user == null)
			throw new BadCredentialsException("Bad credentials");

		new AccountStatusUserDetailsChecker().check(user);

		return user;*/
		
		
		
		return (UserDetails) new User
				("admin","admin",Arrays.asList(
				new SimpleGrantedAuthority("role_admin"),
				new SimpleGrantedAuthority("role_user")));
		
	}
}
