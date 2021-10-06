package com.toolrental.toolRentalAPI.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rentals")
public class Rental {
	
	/**
	 * id de usuario automaticamente generado, no se debe proporcionar
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence_rentals")
	private Long idUser;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	private Tool tool;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}	
}
