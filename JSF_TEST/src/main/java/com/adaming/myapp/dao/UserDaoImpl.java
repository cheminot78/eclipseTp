package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import com.adaming.myapp.entities.User;

public class UserDaoImpl implements IUserDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	private Logger LOGGER = Logger.getLogger("UserDaoImpl");
	
	@Override
	public User add(User user) {
		entityManager.persist(user);
		LOGGER.info("OK c'est ajouté");
		return user;
	}

	@Override
	public User update(User user) {
		entityManager.merge(user);
		LOGGER.info("OK il est modifié" + user);
		return user;
	}

	@Override
	public User getOne(Long id) {
		User c = entityManager.find(User.class, id);
		LOGGER.info("OK le voila" + c);
		return c;
	}

	@Override
	public void delete(Long id) {
		User c = getOne(id);
		entityManager.remove(c);
		LOGGER.info("OK il est supprimé" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Query query = entityManager.createQuery("from User");
		LOGGER.info("OK tout les users" + query.getResultList().size());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllByMc(String mc) {
		final String SQL = "from User c where c.nom like :x or c.prenom like :y";
		Query query = entityManager.createQuery(SQL);
		query.setParameter("x","%"+mc+"%").setParameter("y","%"+mc+"%");
		LOGGER.info("OK par MC ou par KW" + query.getResultList().size());
		return query.getResultList();
	}

}
