package com.jmfrei.simpleapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BussinesUnit {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;

	public BussinesUnit(int id, String name) {
		// super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
