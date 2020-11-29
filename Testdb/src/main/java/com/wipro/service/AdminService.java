package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.DAO.AdminDao;
import com.wipro.model.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Service
public class AdminService implements UserDetailsService{
    @Autowired
	private AdminDao adminDao;
		
	public void saveAdmin(Admin admin) {
		adminDao.save(admin);
	}

	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return (List<Admin>) adminDao.findAll();
	}
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Admin admin = adminDao.findByusername(username);
	        return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
	    }

	public Admin findByusername(String username) {
		return adminDao.findByusername(username);
	}

	/*public UserDetails loadUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
