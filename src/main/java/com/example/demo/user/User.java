package com.example.demo.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message="Name should be more them 2 charectors")
	private String name;
	@Past
	private Date birthDay;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Adress> adress;
	
	
	public User() {
		
	}
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "User [Id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}

	public Set<Adress> getAdress() {
		return adress;
	}

	public void setAdress(Set<Adress> adress) {
		this.adress = adress;
	}
	
	
}
