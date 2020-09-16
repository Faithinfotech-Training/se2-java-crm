package com.example.demo.dao;

import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Login;
import com.example.demo.entity.Users;


@Repository
public class LoginDAOImplementation implements LoginDAO {

	private EntityManager entityManager;
	
	@Autowired
	public LoginDAOImplementation(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	@Override
	@Modifying
	public String login(String username, String password) {
		
		System.out.println("Query successful");
		Query query = entityManager.createNativeQuery("SELECT  login.* FROM  Login WHERE username =?",Login.class);
		System.out.println(username);
	      query.setParameter(1, username);
	      List<Login> loginList=  query.getResultList(); 
	      if(loginList.size()==1)
	      {
	    	  System.out.println("1 result");
	    	  Login login=loginList.get(0);
	    	  int userId=login.getUser().getUserid();
	    	  System.out.println(userId);
		      query = entityManager.createNativeQuery("SELECT  users.* FROM  Users WHERE userid =?",Users.class);
		      query.setParameter(1,userId);
		      
		     List< Users> usersList= query.getResultList();
		     Users users=usersList.get(0);
		     System.out.println(users);
		      if(login.getPassword().equals(password) && users.getRole().getRolename().equals("Manager"))
				{
				return "Successful login of manager";
				}
				
				else if(login.getPassword().equals(password) && users.getRole().getRolename().equals("Admin"))
				{
					return "Successful login of admin";
				}
				else
				{
					return "Not successful,try again";
				}
	      }
		return "Not successful";
	      
	      
		
	}
     @Override
     @Modifying
	public List<Login> getL() {
		Query query = entityManager.createQuery(" FROM Login");
		 System.out.println("Query successful");
		  List<Login> listLogin =  query.getResultList();
		return listLogin;
	}
	
}
