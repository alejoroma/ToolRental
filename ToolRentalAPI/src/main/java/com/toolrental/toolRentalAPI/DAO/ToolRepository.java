package com.toolrental.toolRentalAPI.DAO;

import org.springframework.data.repository.CrudRepository;

import com.toolrental.toolRentalAPI.models.Tool;

public interface ToolRepository extends CrudRepository<Tool, Long>{
	
}
