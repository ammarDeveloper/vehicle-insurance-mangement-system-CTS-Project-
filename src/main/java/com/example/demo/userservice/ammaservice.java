package com.example.demo.userservice;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.ammar;
import com.example.demo.repository.ammarrepo;

@Service
@Transactional
public class ammaservice {
	@Autowired
	private ammarrepo userre;
	public void saveuser(ammar user)
	{
		userre.save(user);
	}
	
	public void getuser(ammar user) {
		Optional<ammar> val =  userre.findById(user.getId());
		System.out.println(val.map(List::of).orElseGet(Collections::emptyList));
		
	}
	

}
