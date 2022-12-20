package com.bank.sophos.service;
import java.util.*;

import com.bank.sophos.entity.Clients;

public interface ClientService {
	
	public Clients createClient(Clients client);
	public List<Clients> getAllClients();
	public Optional<Clients> getClientById(Long id);
	public boolean deleteClientbyId(Long id);
	public Clients modifyClient(Clients client);
	//FALTAN MÉTODOS!
	

	
	

}
