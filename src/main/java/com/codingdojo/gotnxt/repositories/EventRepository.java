package com.codingdojo.gotnxt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.gotnxt.models.Event;
import com.codingdojo.gotnxt.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findAll();
	
	List<Event> findByHost(User host);
	
	@Query(value="SELECT * FROM events WHERE DATE(date) < current_date()", nativeQuery=true)
	List<Event> findEventsFromPast();
	
	@Query(value="SELECT * FROM events WHERE DATE(date) >= current_date()", nativeQuery=true)
	List<Event> findEventsPresentAndFuture();
}