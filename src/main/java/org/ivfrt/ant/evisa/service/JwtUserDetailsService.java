package org.ivfrt.ant.evisa.service;

import java.util.ArrayList;

import org.ivfrt.ant.evisa.dao.UserDao;
import org.ivfrt.ant.evisa.model.DAOUser;
import org.ivfrt.ant.evisa.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser userdetails = new DAOUser();
		userdetails.setUsername(user.getUsername());
		userdetails.setPassword(bcryptEncoder.encode(user.getPassword()));
		userdetails.setUseremail(user.getUseremail());
		userdetails.setUsertype(user.getUsertype());
		userdetails.setUser_regstration_id(user.getUser_regstration_id());
		System.out.println(userdetails);
		return userDao.save(userdetails);
	}
}