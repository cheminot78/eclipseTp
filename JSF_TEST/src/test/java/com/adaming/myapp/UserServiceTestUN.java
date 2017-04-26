package com.adaming.myapp;

import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.User;
import com.adaming.myapp.service.IUserService;

public class UserServiceTestUN {

	static ClassPathXmlApplicationContext context;
	static IUserService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IUserService) context.getBean("clientService");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() {
		
		User client = service.add(new User("nom","prenom"));
		
		assertNotNull(client.getId());
	}

	@Test
	public void testUpdate() {
		User client1 = service.getOne(1L);
		client1.setNom("NOM_NOM");
		service.update(client1);
		User client2 = service.getOne(1L);
		Assert.assertThat(client2.getNom(), IsEqual.equalTo(client1.getNom()));
	
	}

	@Test
	public void testGetOne() {
		User client1 = service.getOne(1L);
		assertTrue(client1 != null);
	}

	@Test
	public void testDelete() {
		List<User> tabUser1 = service.getAll();
		service.delete(1L);
		List<User> tabUser2 = service.getAll();
		assertTrue(tabUser1.size()-1 == tabUser2.size());
	}

	@Test
	public void testGetAll() {
		List<User> tabUser = service.getAll();
		
		assertTrue(tabUser.size()>0);
	}

	@Test
	public void testGetAllByMc() {
		String mc = null;
		User c = null;
		List<User> tabUser = service.getAllByMc(mc);
		
		for(int x =0; x<tabUser.size();x++){
			assertTrue(c.getNom().contains(mc));
		}
		
	}

}
