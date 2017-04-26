package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IUserDao;
import com.adaming.myapp.entities.User;

@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService{

	private IUserDao dao;
	
	private final Logger LOGGER = Logger.getLogger("UserServiceImpl");
	
	public IUserDao getDao() {
		return dao;
	}
	
	public void setDao(IUserDao dao) {
		this.dao = dao;
		LOGGER.info("<-------------DAO Injected------------->");
	}

	@Override
	@Transactional(readOnly = false)
	public User add(User user) {
		// TODO Auto-generated method stub
		return dao.add(user);
	}
	
	@Override
	@Transactional(readOnly = false)
	public User update(User user) {
		// TODO Auto-generated method stub
		return dao.update(user);
	}

	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<User> getAllByMc(String mc) {
		// TODO Auto-generated method stub
		return dao.getAllByMc(mc);
	}

	
}
