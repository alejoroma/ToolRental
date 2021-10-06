package com.toolrental.toolRentalAPI.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolrental.toolRentalAPI.DAO.RentalRepository;
import com.toolrental.toolRentalAPI.DAO.ToolRepository;
import com.toolrental.toolRentalAPI.models.Rental;
import com.toolrental.toolRentalAPI.models.Tool;

@Service
public class ToolService  {

	@Autowired
	private ToolRepository toolRepository;
	@Autowired
	private RentalRepository rentalRepository;
	
	public void create(Tool tool) {
		toolRepository.save(tool);
	}
	
	public List<Tool> getAll(){
		return (List<Tool>) toolRepository.findAll();
	}
	
	public List<Tool> getAllAvailable(){
		List<Tool> allTools =(List<Tool>) toolRepository.findAll();
		List<Tool> availableTools = new ArrayList<>();
		List<Rental> rentalTools = (List<Rental>) rentalRepository.findAll();
		List<Tool> allRentalTools = new ArrayList<>();
		for (Rental rental : rentalTools) {
			if (rental != null) {
				allRentalTools.add(rental.getTool());
			}
		}
		for (Tool tool : allTools) {
			if (tool != null && !allRentalTools.contains(tool)) {
				availableTools.add(tool);
			}
		}
		return availableTools;
	}
	
	public void delete (Tool tool) {
		toolRepository.delete(tool);
	}
	public void edit(Tool tool) {
		toolRepository.save(tool);
	}
}