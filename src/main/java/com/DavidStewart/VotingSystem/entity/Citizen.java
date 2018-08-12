package com.DavidStewart.VotingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citizens") 
public class Citizen {
	
	@Id
	@Column(name="id")
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "citizen_name")
	private String name;
	
	public void setName(String name ) {
		this.name = name;
	}

	public Citizen(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Column(name="hasvoted")
	private Boolean hasVoted;
	
		
	public Boolean getHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(Boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	public Citizen() { super(); }
}
