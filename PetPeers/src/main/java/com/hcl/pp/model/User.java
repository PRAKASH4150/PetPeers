package com.hcl.pp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pet_user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false)
	private long userId;
	@Column(name="USER_NAME",length=25,nullable=false)
	private String userName;
	@Column(name="USER_PASSWD",length=25,nullable=false)
	private String password;
	@Transient
	private String confirmPassword;
	@Transient
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<Pet>();
    
	public Set<Pet> getPets() {
		return pets;
	}
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	public User() {
		super();
	}
	
	public User(long userId, String userName, String password, String confirmPassword, Set<Pet> pets) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.pets = pets;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}