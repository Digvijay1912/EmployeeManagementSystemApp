package com.empmngsys.EmployeeManagementSystemApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empmngsys.EmployeeManagementSystemApp.model.UserPrincipal;
import com.empmngsys.EmployeeManagementSystemApp.model.Users;
import com.empmngsys.EmployeeManagementSystemApp.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userRepo.findByUsername(username);
		
		if (user == null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new UserPrincipal(user);
	}

}
