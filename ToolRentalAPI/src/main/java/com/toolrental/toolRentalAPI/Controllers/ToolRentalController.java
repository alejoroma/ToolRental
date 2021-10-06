package com.toolrental.toolRentalAPI.Controllers;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toolrental.toolRentalAPI.logic.RentalService;
import com.toolrental.toolRentalAPI.logic.ToolService;
import com.toolrental.toolRentalAPI.logic.UserService;
import com.toolrental.toolRentalAPI.models.Rental;
import com.toolrental.toolRentalAPI.models.Tool;
import com.toolrental.toolRentalAPI.models.User;

@RestController
public class ToolRentalController {
	 
	@Autowired
	private ToolService toolLogic;
	@Autowired
	private UserService userLogic;
	@Autowired
	private RentalService rentalLogic;
	
	@GetMapping(value = "/tools")
	public ResponseEntity<?>  getTools() {
		return new ResponseEntity<>(toolLogic.getAll(),HttpStatus.OK);
	}
	@GetMapping(value = "/availableTools")
	public ResponseEntity<?>  getAvailableTools() {
		return new ResponseEntity<>(toolLogic.getAllAvailable(),HttpStatus.OK);
	}
	@GetMapping(value = "/users")
	public ResponseEntity<?>  getUsers() {
		return new ResponseEntity<>(userLogic.getAll(),HttpStatus.OK);
	}
	@GetMapping(value = "/rentals")
	public ResponseEntity<?>  getRentals() {
		return new ResponseEntity<>(rentalLogic.getAll(),HttpStatus.OK);
	}
	@GetMapping(value = "/rentalsById")
	public ResponseEntity<?>  getRentals(@RequestParam Long idUser) {
		return new ResponseEntity<>(rentalLogic.getAll(idUser),HttpStatus.OK);
	}
	
	@PostMapping(value = "/tool")
	public ResponseEntity<?>  createTool(@RequestBody Tool tool) {
		this.toolLogic.create(tool);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping(value = "/user")
	public ResponseEntity<?>  createTool(@RequestBody User user) {
		return new ResponseEntity<>(this.userLogic.create(user), HttpStatus.OK);
	}
	@PostMapping(value = "/rental")
	public ResponseEntity<?>  createTool(@RequestBody Rental rental) {
		this.rentalLogic.create(rental);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping(value = "/tool")
	public ResponseEntity<?> deleteTool(@RequestBody Tool tool){
		this.toolLogic.delete(tool);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping(value = "/user")
	public ResponseEntity<?> deleteUser(@RequestBody User user){
		this.userLogic.delete(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping(value = "/rental")
	public ResponseEntity<?> deleteRental(@RequestBody Rental rental){
		this.rentalLogic.delete(rental);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
