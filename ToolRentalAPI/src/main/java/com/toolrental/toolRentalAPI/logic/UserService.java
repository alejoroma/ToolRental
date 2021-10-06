package com.toolrental.toolRentalAPI.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolrental.toolRentalAPI.DAO.UserRepository;
import com.toolrental.toolRentalAPI.models.Tool;
import com.toolrental.toolRentalAPI.models.User;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepository;
	
	public Long create(User user) {
		return userRepository.save(user).getIdUser();
	}
	
	public List<User> getAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public void delete (User user) {
		userRepository.delete(user);
	}
}