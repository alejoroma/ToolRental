package com.toolrental.toolRentalAPI.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolrental.toolRentalAPI.DAO.ToolRepository;
import com.toolrental.toolRentalAPI.models.Tool;

@Service
public class ToolService  {

	@Autowired
	private ToolRepository toolRepository;
	
	public void create(Tool tool) {
		toolRepository.save(tool);
	}
	
	public List<Tool> getAll(){
		return (List<Tool>) toolRepository.findAll();
	}
	
	public List<Tool> getAllAvailable(){
		List<Tool> allTools =(List<Tool>) toolRepository.findAll();
		List<Tool> availableTools = new ArrayList<>();
		for (Tool tool : allTools) {
			if(tool.getToolStock()>0) {
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