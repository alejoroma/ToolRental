package com.toolrental.toolRentalAPI.DAO;

import org.springframework.data.repository.CrudRepository;

import com.toolrental.toolRentalAPI.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
