package com.toolrental.toolRentalAPI.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tools")
public class Tool {
	
	/**
	 * id de usuario automaticamente generado, no se debe proporcionar
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence_tools")
	private Long idTool;
	
	/**
	 * name of the item, maxlength 60 chars
	 */
	@Column(length = 60)
	private String toolName;
	
	/**
	 * description of the item, maxlength 1024 chars
	 */
	@Column(length = 1024)
	private String toolDescription;
	
	/**
	 * price of the item 
	 */
	private BigDecimal toolPrice;

	public Long getIdTool() {
		return idTool;
	}

	public void setIdTool(Long idTool) {
		this.idTool = idTool;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getToolDescription() {
		return toolDescription;
	}

	public void setToolDescription(String toolDescription) {
		this.toolDescription = toolDescription;
	}

	public BigDecimal getToolPrice() {
		return toolPrice;
	}

	public void setToolPrice(BigDecimal toolPrice) {
		this.toolPrice = toolPrice;
	}
}