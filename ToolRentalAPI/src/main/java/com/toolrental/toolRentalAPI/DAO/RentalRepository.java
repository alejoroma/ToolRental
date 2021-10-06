package com.toolrental.toolRentalAPI.DAO;

import org.springframework.data.repository.CrudRepository;

import com.toolrental.toolRentalAPI.models.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long>{
	
}
