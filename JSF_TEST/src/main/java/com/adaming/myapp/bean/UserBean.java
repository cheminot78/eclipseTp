package com.adaming.myapp.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adaming.myapp.HomeController;
import com.adaming.myapp.entities.User;
import com.adaming.myapp.service.IUserService;

@Component("userBean")
@Scope(value = "session")
/* @ApplicationScoped */
public class UserBean {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Inject
	// instencier le service
	private IUserService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private int nbr1;
	private int nbr2;
	private int result;
	private String nom;
	private String prenom;
	private List<User> tabUser;
	private User user;
	
	

	
	public void calculer(int nbr1, int nbr2) {
		result = nbr1 + nbr2;

	}

	public void add(String nom, String prenom) {
		User user = new User(nom, prenom);
		service.add(user);
		reset();
		getAll();
	}
	
	public void getAll(){
		tabUser = service.getAll();
	}
	
	public void getOne(Long id){
		user = service.getOne(id);
		
	}
	
	public void delete(Long id){
		service.delete(id);
		getAll();
	}
	
	public void update(Long id,String nvnom, String nvprenom){
		user = service.getOne(id);
		user.setNom(nvnom);
		user.setPrenom(nvprenom);
		service.update(user);
		getAll();
	}
	
	public String forward(){
		return "forward";
	}
	
	public String redirect(){
		return "redirect?faces-redirect=true";
	}
	
	public void reset(){
		nom = "";
		prenom = "";
	}

	public int getNbr1() {
		return nbr1;
	}

	public void setNbr1(int nbr1) {
		this.nbr1 = nbr1;
	}

	public int getNbr2() {
		return nbr2;
	}

	public void setNbr2(int nbr2) {
		this.nbr2 = nbr2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getTabUser() {
		return tabUser;
	}

	public void setTabUser(List<User> tabUser) {
		this.tabUser = tabUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public UserBean() {
		System.out.println("---------------OK------------------");
		// TODO Auto-generated constructor stub
	}

}
