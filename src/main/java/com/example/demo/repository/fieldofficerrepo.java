package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.modal.fieldofficer;


public interface fieldofficerrepo extends CrudRepository<fieldofficer, Integer> {
	public fieldofficer findByUsernameAndPassword(String username,String password);
	public fieldofficer findByUsername(String username);
	public fieldofficer findByUsernameAndMblnumberAndEmail(String username, String mblnumber, String email);
	Optional<fieldofficer> findByEmail(String email);
}
