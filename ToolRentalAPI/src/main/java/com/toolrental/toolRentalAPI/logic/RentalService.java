package com.toolrental.toolRentalAPI.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolrental.toolRentalAPI.DAO.RentalRepository;
import com.toolrental.toolRentalAPI.models.Rental;

@Service
public class RentalService  {

	@Autowired
	private RentalRepository rentalRepository;
	
	public void create(Rental rental) {
		rentalRepository.save(rental);
	}
	
	public List<Rental> getAll(){
		return (List<Rental>) rentalRepository.findAll();
	}
	
	public List<Rental> getAll(Long idUser){
		List<Rental> listToolRentedByUser = new ArrayList<>();
		List<Rental> listAllRentals = getAll();
		for (Rental rental : listAllRentals) {
			if (rental.getUser() != null && rental.getUser().getIdUser() == idUser) {
				listToolRentedByUser.add(rental);
			}
		}
		return listToolRentedByUser;
	}
	
	public void delete (Rental rental) {
		rentalRepository.delete(rental);
	}
	
	
}