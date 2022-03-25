package com.codingdojo.gotnxt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.gotnxt.models.Event;
import com.codingdojo.gotnxt.models.User;
import com.codingdojo.gotnxt.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private UserService userServ;
	
	// JOIN Event
	public void addAthletes(Long eventId, Long athleteId){
		Event event = this.eventRepo.findById(eventId).orElse(null);
		User athlete = this.userServ.findUserById(athleteId);
		event.getAthletes().add(athlete);
		this.eventRepo.save(event);
	}
	
	// Leave Event
	public void removeAthlete(Long eventId, User athlete) {
		Event event = this.eventRepo.findById(eventId).orElse(null);
		event.getAthletes().remove(athlete);
		this.eventRepo.save(event);
	}
	
	// Find Host Events
	public List<Event> getHostEvents(Long hostId){
		User host = this.userServ.findUserById(hostId);
		return this.eventRepo.findByHost(host);
	}
	
	//	All Events Not Happened Yet
	public List<Event> eventsToStart(){
		return this.eventRepo.findEventsPresentAndFuture();
	}
	
	//	All Events Completed
	public List<Event> eventsCompleted(){
		return this.eventRepo.findEventsFromPast();
	}
	
	//CRUD
	// All Events
	public List<Event> getAllEvents(){
		return this.eventRepo.findAll();
	}
	// Find One Event
	public Event findEvent(Long eventId) {
		return this.eventRepo.findById(eventId).orElse(null);
	}
	
	// Create Event
	public Event createEvent(Event newEvent) {
		return this.eventRepo.save(newEvent);
	}
	
	// Update Event
	public Event updateEvent(Event event) {
		return this.eventRepo.save(event);
	}
	// Delete Event
	public void deleteEvent(Long id) {
		this.eventRepo.deleteById(id);
	}
	
}
