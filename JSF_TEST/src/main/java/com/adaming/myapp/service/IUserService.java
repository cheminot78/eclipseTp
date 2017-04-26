package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.User;

public interface IUserService {

	User add(User user);
	
	User update(User user);
	
	User getOne(Long id);
	
	void delete(Long id);
	
	List<User> getAll();
	
	List<User> getAllByMc(String mc);
}
