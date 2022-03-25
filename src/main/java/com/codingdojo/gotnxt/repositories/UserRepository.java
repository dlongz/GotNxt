package com.codingdojo.gotnxt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.gotnxt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findAll();
	
	User findByEmail(String email);
	
	User findByUserName(String userName);
	
	@Query(value="SELECT COUNT(id) FROM users", nativeQuery = true)int getCount();
}
