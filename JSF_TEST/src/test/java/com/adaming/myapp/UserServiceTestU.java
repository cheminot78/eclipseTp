package com.adaming.myapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.User;
import com.adaming.myapp.service.IUserService;

public class UserServiceTestU {
	
	private static ClassPathXmlApplicationContext context;
	
	private static IUserService service;
	
	
public static void main(String[] args) {
	
	context = new ClassPathXmlApplicationContext("app.xml");
	
	service = (IUserService) context.getBean("userService");
	User c1 = service.add(new User("Genereux", "Jean"));
	User c2 = service.add(new User("Marquez", "Chris"));
	User c4 = service.add(new User("Le", "Delete"));
	
	User c3 = service.getOne(1L);
	c3.setPrenom("Jean-Marc");
	service.update(c3);
	
	service.getAll();
	
	service.getAllByMc("Ma");
	
	service.delete(3L);
	
	
	
	}
}
