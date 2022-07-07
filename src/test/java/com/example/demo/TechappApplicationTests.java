package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modal.User;
import com.example.demo.modal.fieldofficer;
import com.example.demo.modal.policyadmin;
import com.example.demo.repository.Policyrepo;
import com.example.demo.repository.fieldofficerrepo;
import com.example.demo.repository.userreposirtory;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TechappApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private fieldofficerrepo field_repo;
	
	@Autowired
	private Policyrepo policy_repo;
	
	@Autowired
	private userreposirtory user_repo;
	
	/**
	 * Test for inserting the data into the fieldofficertable table in database
	 */
	@Test
	@Order(1)
	public void insertFieldOfficerTest() {
		fieldofficer fo = new fieldofficer();
		fo.setId(6);
		fo.setCategory("Field Officer");
		fo.setDesignation("Junior Officer");
		fo.setDob("2000-09-01");
		fo.setEmail("test2@gmail.com");
		fo.setFirstname("demo_first_name");
		fo.setLastname("demo_last_name");
		fo.setGender("Male");
		fo.setMblnumber("9087654321");
		fo.setPassword("demo@123");
		fo.setPerm("false");
		fo.setRole("BG Verification");
		fo.setUsername("demo_username");
		fo.setConcern("some concern");
		fo.setReply("some reply");
		field_repo.save(fo);
		
		Assertions.assertThat(fo.getId()).isEqualTo(6);
	}
	
	/**
	 * Test for getting the data from fieldofficertable table from the database
	 */
	@Test
	@Order(2)
	public void getFieldOfficerTest() {
		fieldofficer fo = field_repo.findById(1).get();
		Assertions.assertThat(fo.getFirstname()).isEqualTo("field_officer_1_fn");
	}
	
	/**
	 * Test for getting all the data from fieldofficertable table from the database
	 */
	@Test
	@Order(3)
	public void getListOfFieldOfficer() {
		List<fieldofficer> fieldofficers = (List<fieldofficer>) field_repo.findAll();
		Assertions.assertThat(fieldofficers.size()).isGreaterThan(0);
	}
	
	/**
	 * Test for updating the data in fieldofficertable table from the database
	 */
	@Test
	@Order(4)
	public void updateFieldOfficerTest() {
		fieldofficer fo = field_repo.findById(6).get();
		fo.setEmail("testUpdated@gmail.com");
		fieldofficer fieldofficerUpdated = field_repo.save(fo);
		Assertions.assertThat(fieldofficerUpdated.getEmail()).isEqualTo("testUpdated@gmail.com");
	}
	
	/**
	 * Test for deleting the data from fieldofficertable table from the database
	 */
	@Test
	@Order(5)
	public void deleteFieldOfficerTest() {
		fieldofficer fo = field_repo.findById(6).get();
		field_repo.delete(fo);
		fieldofficer foTest = null;
		Optional<fieldofficer> optionalFO = field_repo.findByEmail("testUpdated@gmail.com"); 
		
		if (optionalFO.isPresent()) {
			foTest = optionalFO.get();
		}
		System.out.println(foTest);
		Assertions.assertThat(foTest).isNull();
	}
	
	
	@Test
	@Order(6)
	public void interPolicyAdminTest() {
		policyadmin content = new policyadmin();
		content.setId(6);
		content.setCategory("Policy Admin");
		content.setDesignation("Junier Officer");
		content.setDob("2000-09-01");
		content.setEmail("test1@gmail.com");
		content.setFirstname("demo_first_name");
		content.setLastname("demo_last_name");
		content.setGender("Male");
		content.setMblnumber("9087654321");
		content.setPassword("demo@123");
		content.setPerm("false");
		content.setRole("BG Verification");
		content.setUsername("demo_username");
		content.setConcern("some concern");
		content.setReply("some reply");
		
		policy_repo.save(content);
		
		Assertions.assertThat(content.getId()).isEqualTo(6);
	}
	
	@Test
	@Order(7)
	public void getPolicyAdminTest() {
		policyadmin pa = policy_repo.findById(1).get();
		Assertions.assertThat(pa.getFirstname()).isEqualTo("policy_ad_1_fn");
	}
	
	@Test
	@Order(8)
	public void getListOfPolicyAdminTest() {
		List<policyadmin> policyadmins = (List<policyadmin>) policy_repo.findAll();
		Assertions.assertThat(policyadmins.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(9)
	public void updatePolicyAdminTest() {
		policyadmin fo = policy_repo.findById(6).get();
		fo.setEmail("testUpdated@gmail.com");
		policyadmin policyadminUpdated = policy_repo.save(fo);
		Assertions.assertThat(policyadminUpdated.getEmail()).isEqualTo("testUpdated@gmail.com");
	}
	
	@Test
	@Order(10)
	public void deletePolicyAdminTest() {
		policyadmin fo = policy_repo.findById(6).get();
		policy_repo.delete(fo);
		policyadmin foTest = null;
		Optional<policyadmin> optionalFO = policy_repo.findByEmail("testUpdated@gmail.com"); 
		
		if (optionalFO.isPresent()) {
			foTest = optionalFO.get();
		}
		System.out.println(foTest);
		Assertions.assertThat(foTest).isNull();
	}
	
	@Test
	@Order(11)
	public void insertUserTest() {
		User user = new User();
		user.setId(7);
		user.setDob("2000-09-01");
		user.setEmail("test2@gmail.com");
		user.setFirstname("demo_first_name");
		user.setLastname("demo_last_name");
		user.setGender("Male");
		user.setLnumber("123476");
		user.setMblnumber("9087654321");
		user.setPassword("demo@123");
		user.setPolicyreq("false");
		user.setPolicyaccept("false");
		user.setUsername("demo_username");
		user.setAd_to_fo("false");
		user.setFo_to_adac("false");
		user.setFo_to_adrej("false");
		user.setAd_to_po("false");
		user.setPo_to_adac("false");
		user.setPo_to_adrej("false");
		
		user_repo.save(user);
		
		Assertions.assertThat(user.getId()).isEqualTo(7);
	}
	
	@Test
	@Order(12)
	public void getUserTest() {
		User user = user_repo.findById(1).get();
		Assertions.assertThat(user.getFirstname()).isEqualTo("Mohammed");
	}
	
	
	
	@Test
	@Order(13)
	public void getListOfUserTest() {
		List<User> users = (List<User>) user_repo.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(14)
	public void updateUserTest() {
		User user = user_repo.findById(7).get();
		user.setEmail("testUpdated@gmail.com");
		User userUpdated = user_repo.save(user);
		Assertions.assertThat(userUpdated.getEmail()).isEqualTo("testUpdated@gmail.com");
	}
}
