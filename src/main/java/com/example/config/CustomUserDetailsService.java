package com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.base.utils.SecureUtil;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
	    
	    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    String password = encoder.encode("password");
	    if (SecureUtil.isApi()) {
	    	// TODO check for API
	    	
		} else {
			// TODO check for web
		}
    	
        return new org.springframework.security.core.userdetails.User("lll",
        		password, authorities);
    }

}
