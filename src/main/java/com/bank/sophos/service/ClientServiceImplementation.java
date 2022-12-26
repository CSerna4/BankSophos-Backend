package com.bank.sophos.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.sophos.entity.Clients;
import com.bank.sophos.exceptions.ResourceNotFoundException;
import com.bank.sophos.repository.ClientRepository;

@Service
public class ClientServiceImplementation implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public Clients createClient(Clients client) {

		if (legalAgeCheck(client.getbirthDate())) {
			
			client.setcreationDate(LocalDate.now());

			Clients newClient = clientRepository.save(client);

			return newClient;

		} else {

			throw new IllegalArgumentException("You can not create a client if it has less than 18 years old.");
		}
	}

	@Override
	public List<Clients> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Clients> getClientById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public boolean deleteClientbyId(Long id){
		
		clientRepository.deleteById(id);
		
		return true;
	}

	@Override
	public Clients modifyClient(Clients client) {

		Optional<Clients> checkID = clientRepository.findById(client.getClientID());
		if (checkID.isPresent()) {
			
			client.setModifUser("Admin");
						
			Clients updatedClient = clientRepository.save(client);
			
			return updatedClient;

		} else {

			throw new ResourceNotFoundException("The ID is not in the system. Please verify.");
		}

	}

	public Boolean legalAgeCheck(LocalDate birthDate) {

		int age = Period.between(birthDate, LocalDate.now()).getYears();

		if (age >= 18) {

			return true;
		} else {

			return false;
		}

	}

}