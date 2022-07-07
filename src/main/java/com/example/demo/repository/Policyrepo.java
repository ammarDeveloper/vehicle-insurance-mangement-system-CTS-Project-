package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modal.User;
import com.example.demo.modal.fieldofficer;
import com.example.demo.modal.policyadmin;

public interface Policyrepo extends CrudRepository<policyadmin, Integer> {
	public policyadmin findByUsernameAndPassword(String username,String password);
	public policyadmin findByUsername(String username);
	public policyadmin findByUsernameAndMblnumberAndEmail(String username, String mblnumber, String email);
	Optional<policyadmin> findByEmail(String email);

}
