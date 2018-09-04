package com.jmfrei.simpleapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String title;
	
	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String code;
	
	private String description;
	
	@ManyToOne()
	private BussinesUnit bussinesUnit;
	
	@ManyToOne()
	private Center center;
	
	@ManyToOne()
	private TecCategory tecCategory;
	
	@ManyToOne()
	private KnowledgeArea knowledgeArea;
	
	
	
}
