package com.example.demo.user;

import java.util.List;


public interface UserDAO {

public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theEmployee);
	
	public void deleteById(int theId);
}
