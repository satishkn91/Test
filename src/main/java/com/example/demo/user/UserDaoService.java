package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class UserDaoService implements UserDAO{

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	public UserDaoService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

	public List<User> findAll() {
		
		Query theQuery = 
				entityManager.createQuery("from User");
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
		
		// return the results		
		return users;
	}

	/*
	 * public void save(User user) { if (user.getId() == null) {
	 * user.setId(++count); } users.add(user); }
	 */


	public void deleteUser(int Id) {
		
		
	}

	@Override
	public User findById(int theId) {
		User theEmployee = 
				entityManager.find(User.class, theId);
		
		// return employee
		return theEmployee;
	}

	@Override
	public void save(User theEmployee) {
		// save or update the employee
		User dbEmployee = entityManager.merge(theEmployee);
				
				// update with id from db ... so we can get generated id for save/insert
				theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
