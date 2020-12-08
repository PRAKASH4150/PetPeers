package com.hcl.pp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PETS")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PET_ID")
	private long id;
	
	@Column(name="PET_NAME",nullable = false, length = 55)
	private String name;
	
	@Column(name="PET_AGE",nullable = false, length = 2)
	private int age;
	
	@Column(name="PET_PLACE",nullable = false, length = 55)
	private String place;
	
	@ManyToOne
	private User owner;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Pet() {
		super();

	}

	public Pet(long id, String name, int age, String place, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.place = place;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", place=" + place + ", owner=" + owner + "]";
	}

}
