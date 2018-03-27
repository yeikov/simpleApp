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
	
	private String title;
	
	private String code;
	
	@ManyToOne()
	private BussinesUnit bussinesUnit;
	
	@ManyToOne()
	private Center center;
	
	@ManyToOne()
	private TecCategory tecCategory;
	
	@ManyToOne()
	private KnowledgeArea knowledgeArea;
	
	private String description;
	
}
