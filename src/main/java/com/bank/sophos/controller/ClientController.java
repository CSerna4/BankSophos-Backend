package com.bank.sophos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.*;

import com.bank.sophos.entity.Clients;
import com.bank.sophos.service.ClientService;

@RestController
@RequestMapping ("/clients")
@CrossOrigin (origins="http://localhost:4200")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@CrossOrigin (origins="http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<Clients>> getClients(){
		
		return new ResponseEntity<>(clientService.getAllClients(),HttpStatus.OK);	
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Clients> getClientById(@PathVariable Long id){
		
		return clientService.getClientById(id)
				.map(client -> new ResponseEntity<>(client, HttpStatus.OK))
				.orElse(new ResponseEntity <>(HttpStatus.NOT_FOUND));		
	}
	
	
	@PostMapping
	@ResponseBody
	@CrossOrigin (origins="http://localhost:4200")
	public ResponseEntity<Clients> createClient(@RequestBody Clients client){
		
		Clients newClient = clientService.createClient(client);
		
		return new ResponseEntity<>(newClient, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Clients> deleteClientById(@PathVariable("id") Long id) {
		
		if (clientService.deleteClientbyId(id)) {
			
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clients> updateClient (@PathVariable Long id, @RequestBody Clients client){
		
		Clients updatedClient = clientService.modifyClient(client);
		
		return new ResponseEntity<>(updatedClient,HttpStatus.OK);
	}
	

}

	

	
