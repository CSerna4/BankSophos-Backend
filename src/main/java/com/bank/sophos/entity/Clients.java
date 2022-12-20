package com.bank.sophos.entity;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table (name="Clients")
public class Clients {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clientID;
	private String idType, name, lastName, email, creationUser, modifUser, idNumber;
	private LocalDate birthDate, creationDate, modifDate;
	
	
	
	public Clients() {
		
		this.creationUser = "Admin";
		
	}
	
	public Clients(Long clientID, String idNumber, String idType, String name, String lastName, String email,
			String creationUser, String modifUser, LocalDate birthDate, LocalDate creationDate, LocalDate modifDate) {
		super();
		this.clientID = clientID;
		this.idNumber = idNumber;
		this.idType = idType;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.creationUser = creationUser;
		this.modifUser = modifUser;
		this.birthDate = birthDate;
		this.creationDate = creationDate;
		this.modifDate = modifDate;
	}


	public Long getClientID() {
		return clientID;
	}


	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getIdType() {
		return idType;
	}


	public void setIdType(String idType) {
		this.idType = idType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getlastName() {
		return lastName;
	}


	public void setlastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCreationUser() {
		return creationUser;
	}


	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}


	public String getModifUser() {
		return modifUser;
	}


	public void setModifUser(String modifUser) {
		this.modifUser = modifUser;
	}


	public LocalDate getbirthDate() {
		return birthDate;
	}


	public void setbirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	public LocalDate getcreationDate() {
		return creationDate;
	}


	public void setcreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}


	public LocalDate getModifDate() {
		return modifDate;
	}


	public void setModifDate(LocalDate modifDate) {
		this.modifDate = modifDate;
	}
	
	
	
	

}
